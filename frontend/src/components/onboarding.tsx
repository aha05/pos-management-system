import { useEffect, useRef, useState, type FormEvent } from "react";
import { Link } from "@/utils/link";
import { PageHeader } from "@/components/page-header";
import { ArrowUpRight, Check, CircleDollarSign, Plus, Trash2 } from "lucide-react";
import { Card, Checkbox, Input, Select } from "@/components/ui/form-controls";
import { Modal } from "@/components/ui/modal";

type LookupOption = { id: number; name: string };
type DocumentEntry = {
  id: number;
  documentType: string;
  fileName: string;
  storagePath: string;
  verified: boolean;
};
type FieldKey =
  | "merchantCode" | "legalName" | "tradeName" | "businessLicense" | "tinNumber"
  | "businessType" | "merchantCategoryId" | "feeProfileId" | "status"
  | "email" | "phoneNumber" | "website" | "country" | "region" | "city"
  | "subCity" | "woreda" | "address" | "houseNo" | "contactFullName"
  | "contactDesignation" | "contactPhone" | "contactEmail" | "primaryContact"
  | "bankName" | "accountNumber" | "accountName" | "currency";
type FormValues = Record<FieldKey, string | boolean>;
type FieldDefinition = {
  key: FieldKey;
  label: string;
  kind?: "select" | "checkbox" | "email" | "tel" | "url";
  options?: Array<{ value: string; label: string }>;
  required?: boolean;
};

const steps = [
  "Business information",
  "Contact information",
  "Contact person",
  "Settlement account",
  "Document",
  "Review & submit",
];

const businessTypes = ["Private Limited Company", "Partnership", "Sole Proprietorship"];
const countries = ["Ethiopia", "Kenya", "Rwanda"];
const regions = ["Addis Ababa", "Oromia", "Amhara"];
const cities = ["Addis Ababa", "Bahir Dar", "Dire Dawa"];
const banks = ["Commercial Bank of Ethiopia", "Awash Bank", "Dashen Bank"];
const currencies = ["ETB", "USD"];
const statuses = ["PENDING", "ACTIVE", "INACTIVE", "SUSPENDED", "CLOSED", "BLOCKED"];

const requiredField = (key: FieldKey, label: string, kind?: FieldDefinition["kind"]): FieldDefinition => ({
  key, label, kind, required: true,
});
const optionalField = (key: FieldKey, label: string, kind?: FieldDefinition["kind"]): FieldDefinition => ({
  key, label, kind,
});
const optionList = (values: string[]) => values.map((value) => ({ value, label: value }));

const getFields = (categories: LookupOption[], feeProfiles: LookupOption[]): Record<number, FieldDefinition[]> => ({
  1: [
    requiredField("merchantCode", "Merchant Code"),
    requiredField("legalName", "Legal Name"),
    requiredField("tradeName", "Trade name"),
    requiredField("businessLicense", "Business registration number"),
    requiredField("tinNumber", "Tax identification number"),
    { ...requiredField("businessType", "Business type", "select"), options: optionList(businessTypes) },
    { ...requiredField("merchantCategoryId", "Merchant category", "select"), options: categories.map(({ id, name }) => ({ value: String(id), label: name })) },
    { ...requiredField("feeProfileId", "Link Fee profile", "select"), options: feeProfiles.map(({ id, name }) => ({ value: String(id), label: name })) },
    { ...requiredField("status", "Status", "select"), options: optionList(statuses) },
  ],
  2: [
    requiredField("email", "Email", "email"),
    requiredField("phoneNumber", "Phone number", "tel"),
    requiredField("website", "Website", "url"),
    { ...requiredField("country", "Country", "select"), options: optionList(countries) },
    { ...requiredField("woreda", "Woreda", "select"), options: optionList(regions) },
    { ...requiredField("subCity", "Sub City", "select"), options: optionList(regions) },
    { ...optionalField("region", "Region", "select"), options: optionList(regions) },
    { ...requiredField("city", "City", "select"), options: optionList(cities) },
    requiredField("address", "Address"),
    requiredField("houseNo", "House No."),
  ],
  3: [
    optionalField("contactFullName", "Full name"),
    optionalField("contactDesignation", "Designation"),
    optionalField("contactPhone", "Phone number", "tel"),
    optionalField("contactEmail", "Email", "email"),
    { ...optionalField("primaryContact", "Primary Contact", "checkbox") },
  ],
  4: [
    { ...optionalField("bankName", "Bank", "select"), options: optionList(banks) },
    optionalField("accountNumber", "Account number"),
    optionalField("accountName", "Account name"),
    { ...optionalField("currency", "Currency", "select"), options: optionList(currencies) },
  ],
});

const initialValues: FormValues = {
  merchantCode: "", legalName: "", tradeName: "", businessLicense: "", tinNumber: "",
  businessType: "", merchantCategoryId: "", feeProfileId: "", status: "PENDING",
  email: "", phoneNumber: "", website: "", country: "", region: "", city: "",
  subCity: "", woreda: "", address: "", houseNo: "", contactFullName: "",
  contactDesignation: "", contactPhone: "", contactEmail: "", primaryContact: false,
  bankName: "", accountNumber: "", accountName: "", currency: "",
};

const sectionTitles: Record<number, string> = {
  1: "Business information",
  2: "Contact information",
  3: "Contact person",
  4: "Settlement account",
  5: "Documents",
};

export const Onboarding = () => {
  const [step, setStep] = useState(1);
  const [values, setValues] = useState<FormValues>(initialValues);
  const [documents, setDocuments] = useState<DocumentEntry[]>([
    { id: 0, documentType: "", fileName: "", storagePath: "", verified: false },
  ]);
  const [categories, setCategories] = useState<LookupOption[]>([]);
  const [feeProfiles, setFeeProfiles] = useState<LookupOption[]>([]);
  const [lookupError, setLookupError] = useState("");
  const [editingStep, setEditingStep] = useState<number | null>(null);
  const [requestError, setRequestError] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [submitting, setSubmitting] = useState(false);
  const [created, setCreated] = useState(false);
  const formRef = useRef<HTMLFormElement>(null);
  const editSnapshot = useRef<{ values: FormValues; documents: DocumentEntry[] } | null>(null);
  const fieldsByStep = getFields(categories, feeProfiles);

  useEffect(() => {
    const loadLookups = async () => {
      const loadLookup = async <T,>(
        label: string,
        url: string,
        mapRows: (rows: T[]) => LookupOption[],
        setOptions: (options: LookupOption[]) => void,
      ): Promise<string | null> => {
        try {
          const response = await fetch(url);
          if (!response.ok) throw new Error(`HTTP ${response.status}`);
          const rows = await response.json() as T[];
          if (!Array.isArray(rows)) throw new Error("The response was not a list.");
          setOptions(mapRows(rows));
          return null;
        } catch (error) {
          const detail = error instanceof Error ? error.message : "Unknown request error";
          const browserAccessHint = detail === "Failed to fetch"
            ? "The browser could not read the response; check the request URL, network, or CORS settings."
            : detail;
          return `${label} lookup failed: ${browserAccessHint}`;
        }
      };

      const errors = await Promise.all([
        loadLookup<{ id: number; categoryName: string }>(
          "Category",
          "http://localhost:8080/merchant/category",
          (rows) => rows.map(({ id, categoryName }) => ({ id, name: categoryName })),
          setCategories,
        ),
        loadLookup<{ id: number; profileName: string }>(
          "Fee profile",
          "http://localhost:8080/fee-profile",
          (rows) => rows.map(({ id, profileName }) => ({ id, name: profileName })),
          setFeeProfiles,
        ),
      ]);
      setLookupError(errors.filter(Boolean).join(" "));
    };
    void loadLookups();
  }, []);

  const updateValue = (key: FieldKey, value: string | boolean) => {
    setValues((current) => ({ ...current, [key]: value }));
    setSuccessMessage("");
  };

  const updateDocument = (id: number, key: keyof Omit<DocumentEntry, "id">, value: string | boolean) => {
    setDocuments((current) => current.map((document) => document.id === id ? { ...document, [key]: value } : document));
    setSuccessMessage("");
  };

  const renderField = (field: FieldDefinition) => {
    if (field.kind === "checkbox") {
      return (
        <label className="inline-checkbox-field" key={field.key}>
          <Checkbox checked={Boolean(values[field.key])} onChange={(event) => updateValue(field.key, event.currentTarget.checked)} />
          <span>{field.label}</span>
        </label>
      );
    }
    return (
      <label key={field.key}>
        {field.label}
        <div className="input-wrap">
          {field.kind === "select" ? (
            <Select
              value={String(values[field.key])}
              required={field.required}
              onChange={(event) => updateValue(field.key, event.currentTarget.value)}
            >
              <option value="" disabled>Select {field.label.toLowerCase()}</option>
              {field.options?.map((option) => <option key={option.value} value={option.value}>{option.label}</option>)}
            </Select>
          ) : (
            <Input
              type={field.kind ?? "text"}
              value={String(values[field.key])}
              required={field.required}
              onChange={(event) => updateValue(field.key, event.currentTarget.value)}
              placeholder={`Enter ${field.label.toLowerCase()}`}
            />
          )}
        </div>
      </label>
    );
  };

  const renderDocuments = () => (
    <>
      {documents.map((document, index) => (
        <section className="document-group full" key={document.id}>
          <div className="document-group-header">
            <b>Document {index + 1}</b>
            {index > 0 && (
              <button type="button" className="remove-document-button" onClick={() => setDocuments((items) => items.filter((item) => item.id !== document.id))}>
                <Trash2 /> Remove
              </button>
            )}
          </div>
          <div className="document-grid">
            <label>Document type<div className="input-wrap"><Input value={document.documentType} onChange={(event) => updateDocument(document.id, "documentType", event.currentTarget.value)} placeholder="Enter document type" /></div></label>
            <label>File name<div className="input-wrap"><Input value={document.fileName} onChange={(event) => updateDocument(document.id, "fileName", event.currentTarget.value)} placeholder="Enter file name" /></div></label>
            <label>Storage path<div className="input-wrap"><Input value={document.storagePath} onChange={(event) => updateDocument(document.id, "storagePath", event.currentTarget.value)} placeholder="Enter storage path" /></div></label>
            <label className="document-verified"><Checkbox checked={document.verified} onChange={(event) => updateDocument(document.id, "verified", event.currentTarget.checked)} /><span>Verified</span></label>
          </div>
        </section>
      ))}
      <button type="button" className="button outline add-document-button" onClick={() => setDocuments((items) => [...items, { id: Math.max(-1, ...items.map((item) => item.id)) + 1, documentType: "", fileName: "", storagePath: "", verified: false }])}>
        <Plus /> Add additional document
      </button>
    </>
  );

  const renderStepFields = (targetStep: number) => (
    <div className="form-grid">
      {targetStep === 5 ? renderDocuments() : fieldsByStep[targetStep]?.map(renderField)}
      {targetStep === 4 && (
        <div className="full info-note">
          <CircleDollarSign /> Settlement details can be reviewed here, but the current merchant creation service does not save settlement accounts yet.
        </div>
      )}
    </div>
  );

  const continueStep = () => {
    if (formRef.current?.reportValidity()) setStep((current) => Math.min(6, current + 1));
  };

  const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (step !== 6 || created) return;
    setRequestError("");
    setSuccessMessage("");
    const requiredKeys: FieldKey[] = [
      "merchantCode", "legalName", "tradeName", "businessLicense", "tinNumber",
      "businessType", "merchantCategoryId", "feeProfileId", "status", "email",
      "phoneNumber", "website", "country", "city", "subCity", "woreda", "address", "houseNo",
    ];
    const missingFields = requiredKeys.filter((key) => !String(values[key]).trim());
    if (missingFields.length) {
      setRequestError("Complete all required business and contact fields before submitting.");
      return;
    }
    setSubmitting(true);
    const payload = {
      merchantCode: values.merchantCode,
      legalName: values.legalName,
      tradeName: values.tradeName,
      businessLicense: values.businessLicense,
      tinNumber: values.tinNumber,
      businessType: values.businessType,
      merchantCategoryId: Number(values.merchantCategoryId),
      feeProfileId: Number(values.feeProfileId),
      status: values.status,
      phoneNumber: values.phoneNumber,
      email: values.email,
      website: values.website,
      country: values.country,
      city: values.city,
      subCity: values.subCity,
      woreda: values.woreda,
      address: values.address,
      houseNo: values.houseNo,
    };
    try {
      const response = await fetch("http://localhost:8080/merchant/create", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });
      if (!response.ok) {
        const detail = await response.text();
        throw new Error(detail || `Merchant creation failed (${response.status}).`);
      }
      const result = await response.json();
      setCreated(true);
      setLookupError("");
      setSuccessMessage(`Merchant ${result.merchantCode ?? values.merchantCode} was created successfully.`);
    } catch (error) {
      setRequestError(error instanceof Error ? error.message : "Unable to create merchant.");
    } finally {
      setSubmitting(false);
    }
  };

  const openEditor = (targetStep: number) => {
    editSnapshot.current = { values: { ...values }, documents: documents.map((item) => ({ ...item })) };
    setEditingStep(targetStep);
  };
  const cancelEdit = () => {
    if (editSnapshot.current) {
      setValues(editSnapshot.current.values);
      setDocuments(editSnapshot.current.documents);
    }
    editSnapshot.current = null;
    setEditingStep(null);
  };
  const saveEdit = () => {
    editSnapshot.current = null;
    setEditingStep(null);
  };
  const displayValue = (field: FieldDefinition) => {
    const value = values[field.key];
    if (typeof value === "boolean") return value ? "Yes" : "No";
    if (!value) return "Not provided";
    return field.options?.find((option) => option.value === value)?.label ?? value;
  };

  return (
    <>
      <PageHeader
        title="Add merchant"
        subtitle="Create a new merchant profile and configure their services."
        action={<Link href="/merchants" className="button ghost">Cancel</Link>}
      />
      <div className="stepper">
        {steps.map((title, index) => (
          <div className={index + 1 === step ? "step active" : index + 1 < step ? "step done" : "step"} key={title}>
            <span>{index + 1 < step ? <Check /> : index + 1}</span><b>{title}</b>
          </div>
        ))}
      </div>
      <Card className="form-card">
        <form ref={formRef} onSubmit={handleSubmit}>
          <div className="form-title">
            <h2>{steps[step - 1]}</h2>
            <p>{step === 1 ? "Enter the merchant's registered business details." : step === 2 ? "Add the merchant's contact and location details." : step === 3 ? "Add a primary contact person." : step === 4 ? "Add the settlement account details." : step === 5 ? "Add supporting business documents." : "Review the information you entered before creating the merchant."}</p>
          </div>
          {lookupError && <div className="form-error" role="alert">{lookupError}</div>}
          {step < 6 ? renderStepFields(step) : (
            <div className="review-grid">
              <div className="full info-note">
                Contact person, settlement account, and document details are shown for review, but the current merchant creation API only saves the merchant profile and its primary contact/location fields.
              </div>
              {steps.slice(0, 5).map((title, index) => {
                const targetStep = index + 1;
                return (
                  <section className="review-card" key={targetStep}>
                    <span>{title}</span>
                    {targetStep === 5 ? (
                      <div className="review-values">
                        {documents.map((document, documentIndex) => (
                          <p key={document.id}><b>Document {documentIndex + 1}:</b> {[document.documentType, document.fileName, document.storagePath].filter(Boolean).join(" · ") || "Not provided"}{document.verified ? " · Verified" : ""}</p>
                        ))}
                      </div>
                    ) : (
                      <div className="review-values">
                        {fieldsByStep[targetStep]?.map((field) => (
                          <p key={field.key}><b>{field.label}:</b> {displayValue(field)}</p>
                        ))}
                      </div>
                    )}
                    <button type="button" className="text-link" disabled={created} onClick={() => openEditor(targetStep)}>Edit</button>
                  </section>
                );
              })}
            </div>
          )}
          {requestError && <div className="form-error" role="alert">{requestError}</div>}
          {successMessage && <div className="form-success" role="status">{successMessage}</div>}
          <div className="form-footer">
            <button type="button" className="button outline" disabled={step === 1 || submitting} onClick={() => setStep((current) => current - 1)}>Back</button>
            <div>
              {step < 6 ? (
                <button type="button" className="button primary" onClick={continueStep}>Continue <ArrowUpRight /></button>
              ) : (
                <button type="submit" className="button primary" disabled={submitting || created}>{submitting ? "Submitting…" : created ? "Merchant created" : "Create merchant"} {!submitting && !created && <ArrowUpRight />}</button>
              )}
            </div>
          </div>
        </form>
      </Card>
      {editingStep !== null && (
        <Modal title={sectionTitles[editingStep]} onClose={cancelEdit} footer={
          <><button type="button" className="button outline" onClick={cancelEdit}>Cancel</button><button type="button" className="button primary" onClick={saveEdit}>Save changes</button></>
        }>
          {renderStepFields(editingStep)}
        </Modal>
      )}
    </>
  );
};
