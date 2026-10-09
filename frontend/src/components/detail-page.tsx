import {
  ArrowUpRight,
  Building2,
  MoreHorizontal,
  WalletCards,
} from "lucide-react";
import { PageHeader }  from "@/components/page-header";
import { Status }  from "@/components/ui/status";
import { Link }  from "@/utils/Link";

export const DetailPage = () => {
  return (
    <>
      <PageHeader
        title="ABC Trading PLC"
        subtitle="Merchant profile and operational details."
        action={
          <div className="header-actions">
            <button className="button outline">Edit merchant</button>
            <button className="button danger">Suspend merchant</button>
          </div>
        }
      />
      <div className="detail-id">
        <span className="merchant-avatar large">AB</span>
        <div>
          <b>MER-000001</b>
          <span>Private Limited · Retail · Created Sep 24, 2024</span>
        </div>
        <Status value="Active" />
      </div>
      <div className="tabs">
        <span className="tab active">Overview</span>
        <span className="tab">Business profile</span>
        <span className="tab">
          Branches <em>12</em>
        </span>
        <span className="tab">Settlement account</span>
        <span className="tab">Fee profile</span>
        <span className="tab">Activity</span>
      </div>
      <div className="detail-grid">
        <section className="card">
          <div className="card-heading">
            <div>
              <h2>Merchant overview</h2>
              <p>Core registration and business information</p>
            </div>
            <button className="icon-button">
              <MoreHorizontal />
            </button>
          </div>
          <div className="detail-fields">
            {[
              ["Merchant ID", "MER-000001"],
              ["Business name", "ABC Trading PLC"],
              ["Registration number", "BRN-2018-08234"],
              ["Tax identification number", "TIN-003928174"],
              ["Business type", "Private Limited Company"],
              ["Merchant category", "Retail"],
              ["Phone number", "+251 11 554 2180"],
              ["Email", "finance@abctrading.et"],
            ].map((x) => (
              <div>
                <span>{x[0]}</span>
                <b>{x[1]}</b>
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
            <span className="mock-badge">Mock account</span>
          </div>
          <div className="account-box">
            <WalletCards />
            <div>
              <span>Commercial Bank of Ethiopia</span>
              <b>•••• •••• •••• 6789</b>
              <small>Account name: ABC Trading PLC</small>
            </div>
            <span className="currency">ETB</span>
          </div>
          <div className="info-note">
            Settlement accounts are simulated for this environment and are not
            connected to a core banking system.
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
            href="/merchants/MER-000001/branches"
            className="button outline"
          >
            Manage branches <ArrowUpRight />
          </Link>
        </div>
        <div className="mini-table">
          {[
            "B001 · Bole Main Branch",
            "B002 · Piassa Branch",
            "B003 · CMC Branch",
          ].map((x, i) => (
            <div className="mini-row" key={x}>
              <div className="branch-icon">
                <Building2 />
              </div>
              <div className="mini-name">
                <b>{x}</b>
                <span>
                  {["Addis Ababa", "Addis Ababa", "Addis Ababa"][i]} · +251 11
                  554 2180
                </span>
              </div>
              <Status value="Active" />
              <span className="date">Added Sep {24 - i}</span>
            </div>
          ))}
        </div>
      </section>
    </>
  );
}