import { useEffect, useState, type FormEvent } from "react";
import {
  ArrowUpRight,
  Building2,
  Edit,
  LoaderCircle,
  MoreHorizontal,
  WalletCards,
} from "lucide-react";
import { PageHeader } from "@/components/page-header";
import { Status } from "@/components/ui/status";
import { Link } from "@/utils/link";
import { Modal } from "@/components/ui/modal";
import { Input, Select } from "@/components/ui/form-controls";
import {
  merchantService,
  type MerchantInformation,
  type MerchantRequest,
} from "@/services/merchant/merchant.service";
import { usePathname } from "@/components/use-path-name";
import { categoryService } from "@/services/merchant/category.service";
import { feeProfileService } from "@/services/merchant/fee-profile.service";

const statuses = [
  "PENDING",
  "ACTIVE",
  "INACTIVE",
  "SUSPENDED",
  "CLOSED",
  "BLOCKED",
];
type ExtraEditData = {
  contactFullName: string;
  contactDesignation: string;
  contactPhone: string;
  contactEmail: string;
  primaryContact: string;
  bankName: string;
  bankCode: string;
  accountNumber: string;
  accountHolderName: string;
  currency: string;
  accountServiceReference: string;
  isPrimary: string;
  active: string;
  documentType: string;
  fileName: string;
  storagePath: string;
  verified: string;
};
const initialExtraEditData: ExtraEditData = {
  contactFullName: "Abebe Kebede",
  contactDesignation: "Finance Manager",
  contactPhone: "+251 911 234 567",
  contactEmail: "finance@example.com",
  primaryContact: "Yes",
  bankName: "Commercial Bank of Ethiopia",
  bankCode: "CBE",
  accountNumber: "1000123456789",
  accountHolderName: "ABC Trading PLC",
  currency: "ETB",
  accountServiceReference: "ASR-00001",
  isPrimary: "Yes",
  active: "Yes",
  documentType: "Business License",
  fileName: "business-license.pdf",
  storagePath: "/demo/documents/business-license.pdf",
  verified: "No",
};

export const DetailPage = () => {
  const path = usePathname() || "";
  const id = Number(path.match(/^\/merchants\/(\d+)/)?.[1]);
  const [merchant, setMerchant] = useState<MerchantInformation | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [editing, setEditing] = useState(false);
  const [saving, setSaving] = useState(false);
  const [form, setForm] = useState<MerchantRequest | null>(null);
  const [categories, setCategories] = useState<
    Array<{ id: number; name: string }>
  >([]);
  const [feeProfiles, setFeeProfiles] = useState<
    Array<{ id: number; name: string }>
  >([]);
  const [extraEditData, setExtraEditData] =
    useState<ExtraEditData>(initialExtraEditData);

  const loadMerchant = async () => {
    if (!Number.isFinite(id) || id <= 0) {
      setError("Invalid merchant ID.");
      setLoading(false);
      return;
    }
    try {
      const data = await merchantService.getMerchantInfoById(id);
      setMerchant(data);
      setError("");
    } catch {
      setError("Unable to load merchant details.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    void loadMerchant();
    void Promise.all([categoryService.getAll(), feeProfileService.getAll()])
      .then(([categoryRows, feeRows]) => {
        setCategories(
          categoryRows.map(({ id: categoryId, categoryName }) => ({
            id: categoryId,
            name: categoryName,
          })),
        );
        setFeeProfiles(
          feeRows.map(({ id: profileId, profileName }) => ({
            id: profileId,
            name: profileName,
          })),
        );
      })
      .catch(() => undefined);
  }, [id]);

  const openEditor = () => {
    if (!merchant) return;
    setForm({
      merchantCode: merchant.merchantCode,
      legalName: merchant.legalName,
      tradeName: merchant.tradeName,
      businessLicense: merchant.businessLicense,
      tinNumber: merchant.tinNumber,
      businessType: merchant.businessType,
      merchantCategoryId:
        categories.find(({ name }) => name === merchant.category)?.id ?? 0,
      feeProfileId:
        feeProfiles.find(({ name }) => name === merchant.feeProfile)?.id ?? 0,
      status: merchant.status,
      phoneNumber: merchant.phoneNumber,
      email: merchant.email,
      website: merchant.website,
      country: merchant.country,
      city: merchant.city,
      subCity: merchant.subCity,
      woreda: merchant.woreda,
      address: merchant.address,
      houseNo: merchant.houseNo,
    });
    setEditing(true);
  };

  const updateField = (key: keyof MerchantRequest, value: string) => {
    setForm((current) =>
      current
        ? {
            ...current,
            [key]:
              key === "merchantCategoryId" || key === "feeProfileId"
                ? Number(value)
                : value,
          }
        : current,
    );
  };

  const updateExtraField = (key: keyof ExtraEditData, value: string) => {
    setExtraEditData((current) => ({ ...current, [key]: value }));
  };

  const save = async (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (!form || !merchant || saving) return;
    setSaving(true);
    setError("");
    try {
      await merchantService.updateMerchant(merchant.id, form);
      setEditing(false);
      setLoading(true);
      await loadMerchant();
    } catch {
      setError("Unable to save merchant changes. Please try again.");
    } finally {
      setSaving(false);
    }
  };

  if (loading) return <div className="card">Loading merchant…</div>;
  if (error && !merchant)
    return (
      <div className="card form-error" role="alert">
        {error}
      </div>
    );
  if (!merchant) return null;

  const fields: Array<[keyof MerchantRequest, string]> = [
    ["merchantCode", "Merchant code"],
    ["legalName", "Legal name"],
    ["tradeName", "Trade name"],
    ["businessLicense", "Business registration number"],
    ["tinNumber", "Tax identification number"],
    ["businessType", "Business type"],
    ["phoneNumber", "Phone number"],
    ["email", "Email"],
    ["website", "Website"],
    ["country", "Country"],
    ["city", "City"],
    ["subCity", "Sub city"],
    ["woreda", "Woreda"],
    ["address", "Address"],
    ["houseNo", "House number"],
  ];

  return (
    <>
      <PageHeader
        title={merchant.tradeName || merchant.legalName}
        subtitle="Merchant profile and operational details."
        action={
          <div className="header-actions">
            <button className="button outline" onClick={openEditor}>
              <Edit /> Edit merchant
            </button>
          </div>
        }
      />
      {error && (
        <div className="form-error" role="alert">
          {error}
        </div>
      )}
      <div className="detail-id">
        <span className="merchant-avatar large">
          {merchant.tradeName.slice(0, 2)}
        </span>
        <div>
          <b>{merchant.merchantCode}</b>
          <span>
            {merchant.businessType} · {merchant.category} · Created{" "}
            {new Date(merchant.createdAt).toLocaleDateString()}
          </span>
        </div>
        <Status value={merchant.status} />
      </div>
      <div className="tabs" />
      <div className="detail-grid">
        <section className="card">
          <div className="card-heading">
            <div>
              <h2>Merchant overview</h2>
              <p>Core registration and business information</p>
            </div>
            <button className="icon-button" aria-label="More merchant actions">
              <MoreHorizontal />
            </button>
          </div>
          <div className="detail-fields">
            {[
              ["Merchant ID", merchant.merchantCode],
              ["Business name", merchant.legalName],
              ["Trade name", merchant.tradeName],
              ["Registration number", merchant.businessLicense],
              ["Tax identification number", merchant.tinNumber],
              ["Business type", merchant.businessType],
              ["Merchant category", merchant.category],
              ["Phone number", merchant.phoneNumber],
              ["Email", merchant.email],
              ["Website", merchant.website],
              [
                "Address",
                [merchant.address, merchant.city, merchant.country]
                  .filter(Boolean)
                  .join(", "),
              ],
            ].map(([label, value]) => (
              <div key={label}>
                <span>{label}</span>
                <b>{value || "—"}</b>
              </div>
            ))}
          </div>
        </section>
        <section className="card">
          <div className="card-heading">
            <div>
              <h2>Settlement account</h2>
              <p>Configured payout destination</p>
            </div>
          </div>
          <div className="account-box">
            <WalletCards />
            <div>
              <span>Account details are not available</span>
              <b>—</b>
              <small>{merchant.tradeName}</small>
            </div>
          </div>
        </section>
      </div>
      <section className="card branches-preview">
        <div className="card-heading">
          <div>
            <h2>Branches</h2>
            <p>Locations connected to this merchant</p>
          </div>
          <Link
            href={`/merchants/${merchant.id}/branches`}
            className="button outline"
          >
            Manage branches <ArrowUpRight />
          </Link>
        </div>
        <div className="mini-table">
          <div className="mini-row">
            <div className="branch-icon">
              <Building2 />
            </div>
            <div className="mini-name">
              <b>{merchant.branch || "No branch information"}</b>
              <span>
                {merchant.city}
                {merchant.phoneNumber ? ` · ${merchant.phoneNumber}` : ""}
              </span>
            </div>
            <Status value={merchant.status} />
          </div>
        </div>
      </section>
      {editing && form && (
        <Modal
          title="merchant"
          onClose={() => !saving && setEditing(false)}
          footer={null}
        >
          <form onSubmit={save}>
            <div className="form-grid">
              <div className="full form-title">
                <h2>Business information</h2>
                <p>Merchant registration and profile details</p>
              </div>
              {fields.map(([key, label]) => (
                <label key={key}>
                  {label}
                  <div className="input-wrap">
                    <Input
                      required={
                        !["website", "subCity", "woreda", "houseNo"].includes(
                          key,
                        )
                      }
                      type={
                        key === "email"
                          ? "email"
                          : key === "website"
                            ? "url"
                            : "text"
                      }
                      value={String(form[key])}
                      onChange={(event) =>
                        updateField(key, event.currentTarget.value)
                      }
                    />
                  </div>
                </label>
              ))}
              <label>
                Merchant category
                <div className="input-wrap">
                  <Select
                    required
                    value={String(form.merchantCategoryId || "")}
                    onChange={(event) =>
                      updateField(
                        "merchantCategoryId",
                        event.currentTarget.value,
                      )
                    }
                  >
                    <option value="">Select category</option>
                    {categories.map(({ id: categoryId, name }) => (
                      <option key={categoryId} value={categoryId}>
                        {name}
                      </option>
                    ))}
                  </Select>
                </div>
              </label>
              <label>
                Fee profile
                <div className="input-wrap">
                  <Select
                    required
                    value={String(form.feeProfileId || "")}
                    onChange={(event) =>
                      updateField("feeProfileId", event.currentTarget.value)
                    }
                  >
                    <option value="">Select fee profile</option>
                    {feeProfiles.map(({ id: profileId, name }) => (
                      <option key={profileId} value={profileId}>
                        {name}
                      </option>
                    ))}
                  </Select>
                </div>
              </label>
              <label>
                Status
                <div className="input-wrap">
                  <Select
                    value={form.status}
                    onChange={(event) =>
                      updateField("status", event.currentTarget.value)
                    }
                  >
                    {statuses.map((value) => (
                      <option key={value}>{value}</option>
                    ))}
                  </Select>
                </div>
              </label>
              <div className="full form-title">
                <h2>Contact person</h2>
                <p>Primary merchant contact details</p>
              </div>
              {(
                [
                  ["contactFullName", "Full name"],
                  ["contactDesignation", "Designation"],
                  ["contactPhone", "Phone number"],
                  ["contactEmail", "Email"],
                  ["primaryContact", "Primary contact"],
                ] as Array<[keyof ExtraEditData, string]>
              ).map(([key, label]) => (
                <label key={key}>
                  {label}
                  <div className="input-wrap">
                    <Input
                      type={key === "contactEmail" ? "email" : "text"}
                      value={extraEditData[key]}
                      onChange={(event) =>
                        updateExtraField(key, event.currentTarget.value)
                      }
                    />
                  </div>
                </label>
              ))}
              <div className="full form-title">
                <h2>Settlement account</h2>
                <p>Payout account details</p>
              </div>
              {(
                [
                  ["bankName", "Bank"],
                  ["bankCode", "Bank code"],
                  ["accountNumber", "Account number"],
                  ["accountHolderName", "Account holder name"],
                  ["currency", "Currency"],
                  ["accountServiceReference", "Account service reference"],
                  ["isPrimary", "Primary account"],
                  ["active", "Active"],
                ] as Array<[keyof ExtraEditData, string]>
              ).map(([key, label]) => (
                <label key={key}>
                  {label}
                  <div className="input-wrap">
                    <Input
                      value={extraEditData[key]}
                      onChange={(event) =>
                        updateExtraField(key, event.currentTarget.value)
                      }
                    />
                  </div>
                </label>
              ))}
              <div className="full form-title">
                <h2>Documents</h2>
                <p>Supporting business document details</p>
              </div>
              {(
                [
                  ["documentType", "Document type"],
                  ["fileName", "File name"],
                  ["storagePath", "Storage path"],
                  ["verified", "Verified"],
                ] as Array<[keyof ExtraEditData, string]>
              ).map(([key, label]) => (
                <label key={key}>
                  {label}
                  <div className="input-wrap">
                    <Input
                      value={extraEditData[key]}
                      onChange={(event) =>
                        updateExtraField(key, event.currentTarget.value)
                      }
                    />
                  </div>
                </label>
              ))}
            </div>
            <p className="info-note">
              Contact, settlement, and document values are demo data. They
              remain in this modal only and are not sent to the API.
            </p>
            <div className="edit-modal-footer">
              <button
                type="button"
                className="button outline"
                disabled={saving}
                onClick={() => setEditing(false)}
              >
                Cancel
              </button>
              <button
                type="submit"
                className="button primary"
                disabled={saving}
              >
                {saving ? (
                  <>
                    <LoaderCircle className="submit-spinner" /> Saving…
                  </>
                ) : (
                  "Save changes"
                )}
              </button>
            </div>
          </form>
        </Modal>
      )}
    </>
  );
};
