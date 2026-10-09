import { useState } from "react";
import { Link }  from "@/utils/Link";
import { PageHeader }  from "@/components/page-header";
import {
  ArrowUpRight,
  Check,
  ChevronDown,
  CircleDollarSign,
} from "lucide-react";

export const Onboarding = () => {
  const [step, setStep] = useState(1);
  return (
    <>
      <PageHeader
        title="Add merchant"
        subtitle="Create a new merchant profile and configure their services."
        action={
          <Link href="/merchants" className="button ghost">
            Cancel
          </Link>
        }
      />
      <div className="stepper">
        {[
          "Business information",
          "Contact information",
          "Settlement account",
          "Fee profile",
          "Review & submit",
        ].map((x, i) => (
          <div
            className={
              i + 1 === step
                ? "step active"
                : i + 1 < step
                  ? "step done"
                  : "step"
            }
            key={x}
          >
            <span>{i + 1 < step ? <Check /> : i + 1}</span>
            <b>{x}</b>
          </div>
        ))}
      </div>
      <div className="card form-card">
        <div className="form-title">
          <h2>
            {
              [
                "Business information",
                "Contact information",
                "Settlement account",
                "Fee profile",
                "Review & submit",
              ][step - 1]
            }
          </h2>
          <p>
            {step === 1
              ? "Tell us about the business you are onboarding."
              : step === 2
                ? "Add a primary contact for this merchant."
                : step === 3
                  ? "Configure the payout destination for this merchant."
                  : step === 4
                    ? "Choose how this merchant will be charged."
                    : "Review the information before submitting."}
          </p>
        </div>
        {step < 5 ? (
          <div className="form-grid">
            {(step === 1
              ? [
                  "Business name",
                  "Trading name",
                  "Business registration number",
                  "Tax identification number",
                  "Business type",
                  "Merchant category",
                  "Description",
                ]
              : step === 2
                ? [
                    "Contact person",
                    "Phone number",
                    "Email",
                    "Website",
                    "Country",
                    "Region",
                    "City",
                    "Address",
                  ]
                : step === 3
                  ? ["Bank", "Account number", "Account name", "Currency"]
                  : ["Fee profile", "Transaction fee", "Settlement frequency"]
            ).map((x) => (
              <label
                className={x === "Description" || x === "Address" ? "full" : ""}
                key={x}
              >
                {x}
                <div className="input-wrap">
                  <input
                    placeholder={
                      x === "Transaction fee"
                        ? "e.g. 1.5%"
                        : `Enter ${x.toLowerCase()}`
                    }
                  />
                  {[
                    "Business type",
                    "Merchant category",
                    "Country",
                    "Region",
                    "City",
                    "Bank",
                    "Currency",
                    "Fee profile",
                    "Settlement frequency",
                  ].includes(x) && <ChevronDown />}
                </div>
              </label>
            ))}
            {step === 3 && (
              <div className="full info-note">
                <CircleDollarSign /> Settlement accounts are currently
                simulated. This will later integrate with the bank/core banking
                system.
              </div>
            )}
          </div>
        ) : (
          <div className="review-grid">
            {[
              [
                "Business information",
                "ABC Trading PLC",
                "Private Limited Company · Retail",
              ],
              [
                "Contact information",
                "Dawit Bekele",
                "+251 91 112 3456 · finance@abctrading.et",
              ],
              [
                "Settlement account",
                "Commercial Bank of Ethiopia",
                "•••• •••• •••• 6789 · ETB",
              ],
              [
                "Fee profile",
                "Premium",
                "1.2% transaction fee · Daily settlement",
              ],
            ].map((x) => (
              <div className="review-card">
                <span>{x[0]}</span>
                <b>{x[1]}</b>
                <small>{x[2]}</small>
                <button className="text-link">Edit</button>
              </div>
            ))}
          </div>
        )}
        <div className="form-footer">
          <button
            className="button outline"
            disabled={step === 1}
            onClick={() => setStep(step - 1)}
          >
            Back
          </button>
          <div>
            <button className="button ghost">Save as draft</button>
            <button
              className="button primary"
              onClick={() => setStep(Math.min(5, step + 1))}
            >
              {step === 5 ? "Submit merchant" : "Continue"} <ArrowUpRight />
            </button>
          </div>
        </div>
      </div>
    </>
  );
}