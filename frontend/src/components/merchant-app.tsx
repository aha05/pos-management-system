"use client";

import { useEffect, useMemo, useRef, useState } from "react";
import type { AnchorHTMLAttributes } from "react";
import {
  Activity,
  ArrowUpRight,
  Bell,
  Building2,
  Check,
  ChevronDown,
  CircleDollarSign,
  CreditCard,
  FileText,
  Filter,
  LayoutDashboard,
  Menu,
  MoreHorizontal,
  Plus,
  Search,
  Settings,
  ShieldCheck,
  Store,
  Tag,
  Users,
  WalletCards,
  X,
} from "lucide-react";

function Link({
  href,
  ...props
}: AnchorHTMLAttributes<HTMLAnchorElement> & { href: string }) {
  return <a href={href} {...props} />;
}
function usePathname() {
  const [path, setPath] = useState(window.location.pathname);
  useEffect(() => {
    const update = () => setPath(window.location.pathname);
    window.addEventListener("popstate", update);
    return () => window.removeEventListener("popstate", update);
  }, []);
  return path;
}

const merchants = [
  {
    id: "MER-000001",
    name: "ABC Trading PLC",
    type: "Private Limited",
    category: "Retail",
    phone: "+251 11 554 2180",
    branches: 12,
    account: "1000123456789",
    status: "Active",
    date: "Sep 24, 2024",
  },
  {
    id: "MER-000002",
    name: "Blue Nile Hospitality",
    type: "Private Limited",
    category: "Hotel",
    phone: "+251 11 667 4302",
    branches: 4,
    account: "1000123456842",
    status: "Active",
    date: "Sep 22, 2024",
  },
  {
    id: "MER-000003",
    name: "Swift Ride Ethiopia",
    type: "Partnership",
    category: "Transportation",
    phone: "+251 91 123 7711",
    branches: 8,
    account: "1000123456990",
    status: "Pending",
    date: "Sep 21, 2024",
  },
  {
    id: "MER-000004",
    name: "Mekdes Pharmacy",
    type: "Sole Proprietorship",
    category: "Healthcare",
    phone: "+251 92 443 1098",
    branches: 2,
    account: "1000123456021",
    status: "Suspended",
    date: "Sep 19, 2024",
  },
  {
    id: "MER-000005",
    name: "Addis Fresh Market",
    type: "Private Limited",
    category: "Supermarket",
    phone: "+251 11 882 1900",
    branches: 17,
    account: "1000123456114",
    status: "Active",
    date: "Sep 18, 2024",
  },
  {
    id: "MER-000006",
    name: "Lumen Learning Center",
    type: "Private Limited",
    category: "Education",
    phone: "+251 93 020 8844",
    branches: 3,
    account: "1000123456230",
    status: "Active",
    date: "Sep 16, 2024",
  },
];
const categories = [
  [
    "5411",
    "Grocery Stores",
    "Everyday grocery and food retailers",
    "184",
    "Active",
  ],
  [
    "5812",
    "Restaurants",
    "Full-service and quick-service dining",
    "156",
    "Active",
  ],
  ["7011", "Hotels", "Hotels, motels and accommodation", "48", "Active"],
  ["4722", "Travel Agencies", "Travel and ticketing services", "35", "Active"],
];
const fees = [
  ["Standard", "For growing businesses", "1.5%", "Daily", "742", "Active"],
  ["Premium", "For established merchants", "1.2%", "Daily", "328", "Active"],
  ["Enterprise", "For strategic accounts", "0.8%", "Monthly", "96", "Active"],
];

function Status({ value }: { value: string }) {
  return (
    <span className={`status status-${value.toLowerCase()}`}>
      <span />
      {value}
    </span>
  );
}
function Metric({ label, value, change, icon: Icon, tone }: any) {
  return (
    <div className="metric">
      <div className={`metric-icon ${tone}`}>
        <Icon />
      </div>
      <div>
        <p>{label}</p>
        <strong>{value}</strong>
        <small>
          <span className="up">{change}</span> vs last month
        </small>
      </div>
    </div>
  );
}
function PageHeader({ title, subtitle, action }: any) {
  return (
    <div className="page-header">
      <div>
        <div className="eyebrow">Merchant services / Operations</div>
        <h1>{title}</h1>
        <p>{subtitle}</p>
      </div>
      {action}
    </div>
  );
}
function Sidebar({ open, setOpen }: any) {
  const path = usePathname();
  const links = [
    ["/", "Dashboard", LayoutDashboard],
    ["/merchants", "Merchants", Store],
    ["/branches", "Branches", Building2],
    ["/merchant-categories", "Merchant Categories", Tag],
    ["/fee-profiles", "Fee Profiles", CreditCard],
    ["/settlement-accounts", "Settlement Accounts", WalletCards],
    ["/settings", "Settings", Settings],
  ];
  return (
    <>
      <button
        className="mobile-menu"
        onClick={() => setOpen(!open)}
        aria-label="Toggle navigation"
      >
        <Menu />
      </button>
      <aside className={open ? "sidebar open" : "sidebar"}>
        <div className="brand">
          <div className="brand-mark">
            <ShieldCheck />
          </div>
          <div>
            <b>POSMS</b>
            <span>MERCHANT SERVICES</span>
          </div>
        </div>
        <div className="workspace">
          <div className="workspace-avatar">MS</div>
          <div>
            <b>Merchant Services</b>
            <span>Operations workspace</span>
          </div>
          <ChevronDown />
        </div>
        <nav>
          {links.map(([href, label, Icon]: any) => (
            <Link
              key={href}
              href={href}
              className={
                path === href ||
                (href === "/merchants" && path?.startsWith("/merchants"))
                  ? "active"
                  : ""
              }
              onClick={() => setOpen(false)}
            >
              <Icon />
              <span>{label}</span>
              {label === "Merchants" && <i>1,248</i>}
            </Link>
          ))}
        </nav>
        <div className="sidebar-bottom">
          <div className="support">
            <div className="support-icon">
              <Activity />
            </div>
            <div>
              <b>Need help?</b>
              <span>Contact operations support</span>
            </div>
          </div>
          <div className="user">
            <div className="avatar">NA</div>
            <div>
              <b>Nadia Abebe</b>
              <span>Administrator</span>
            </div>
            <MoreHorizontal />
          </div>
        </div>
      </aside>
    </>
  );
}

function Dashboard({ onAddMerchant }: { onAddMerchant: () => void }) {
  return (
    <>
      <PageHeader
        title="Good morning, Nadia"
        subtitle="Here is what’s happening with your merchant network today."
      />
      <div className="metrics">
        <Metric
          label="Total Merchants"
          value="1,248"
          change="+8.2%"
          icon={Store}
          tone="blue"
        />
        <Metric
          label="Active Merchants"
          value="1,182"
          change="+6.4%"
          icon={ShieldCheck}
          tone="green"
        />
        <Metric
          label="Pending Onboarding"
          value="24"
          change="+3.1%"
          icon={FileText}
          tone="amber"
        />
        <Metric
          label="Total Branches"
          value="2,846"
          change="+11.8%"
          icon={Building2}
          tone="purple"
        />
      </div>
      <div className="dashboard-grid">
        <section className="card chart-card">
          <div className="card-heading">
            <div>
              <h2>Merchant overview</h2>
              <p>Network growth and onboarding activity</p>
            </div>
            <button className="select">
              Last 30 days <ChevronDown />
            </button>
          </div>
          <div className="chart">
            <div className="y-labels">
              <span>1,300</span>
              <span>1,200</span>
              <span>1,100</span>
              <span>1,000</span>
              <span>900</span>
            </div>
            <div className="chart-area">
              <div className="grid-lines">
                <i />
                <i />
                <i />
                <i />
                <i />
              </div>
              <svg
                viewBox="0 0 700 220"
                preserveAspectRatio="none"
                className="line-chart"
              >
                <path
                  d="M0 185 C70 170, 100 180, 150 145 S230 160, 280 115 S360 135, 410 95 S500 110, 550 65 S630 82, 700 28"
                  fill="none"
                  stroke="currentColor"
                  strokeWidth="3"
                />
                <path
                  d="M0 185 C70 170, 100 180, 150 145 S230 160, 280 115 S360 135, 410 95 S500 110, 550 65 S630 82, 700 28 L700 220 L0 220Z"
                  fill="currentColor"
                  opacity=".08"
                />
              </svg>
              <div className="x-labels">
                <span>Sep 01</span>
                <span>Sep 08</span>
                <span>Sep 15</span>
                <span>Sep 22</span>
                <span>Sep 30</span>
              </div>
            </div>
          </div>
          <div className="chart-legend">
            <span>
              <i className="legend-blue" /> Total merchants
            </span>
            <span>
              <i className="legend-gray" /> New onboarded
            </span>
          </div>
        </section>
        <section className="card status-card">
          <div className="card-heading">
            <div>
              <h2>Merchant status</h2>
              <p>Current network distribution</p>
            </div>
            <MoreHorizontal />
          </div>
          <div className="donut-wrap">
            <div className="donut">
              <div>
                <strong>1,248</strong>
                <span>Total</span>
              </div>
            </div>
            <div className="legend-list">
              <div>
                <i className="dot green" />
                <span>Active</span>
                <b>
                  1,182 <small>94.7%</small>
                </b>
              </div>
              <div>
                <i className="dot red" />
                <span>Suspended</span>
                <b>
                  42 <small>3.4%</small>
                </b>
              </div>
              <div>
                <i className="dot amber" />
                <span>Pending</span>
                <b>
                  24 <small>1.9%</small>
                </b>
              </div>
            </div>
          </div>
        </section>
      </div>
      <div className="bottom-grid">
        <section className="card">
          <div className="card-heading">
            <div>
              <h2>Recent merchants</h2>
              <p>Latest additions to your network</p>
            </div>
            <Link href="/merchants" className="text-link">
              View all <ArrowUpRight />
            </Link>
          </div>
          <div className="mini-table">
            {merchants.slice(0, 4).map((m) => (
              <div className="mini-row" key={m.id}>
                <div className="merchant-avatar">
                  {m.name
                    .split(" ")
                    .map((x) => x[0])
                    .join("")
                    .slice(0, 2)}
                </div>
                <div className="mini-name">
                  <b>{m.name}</b>
                  <span>
                    {m.id} · {m.category}
                  </span>
                </div>
                <Status value={m.status} />
                <span className="date">{m.date}</span>
              </div>
            ))}
          </div>
        </section>
        <section className="card activity-card">
          <div className="card-heading">
            <div>
              <h2>Recent activity</h2>
              <p>Latest actions across the platform</p>
            </div>
            <button className="icon-button">
              <MoreHorizontal />
            </button>
          </div>
          {[
            [
              "Merchant activated",
              "ABC Trading PLC was activated",
              "2 min ago",
              "green",
            ],
            [
              "Fee profile assigned",
              "Premium profile assigned to Blue Nile Hospitality",
              "1 hr ago",
              "blue",
            ],
            [
              "Branch added",
              "New branch added to Addis Fresh Market",
              "3 hrs ago",
              "purple",
            ],
            [
              "Merchant suspended",
              "Mekdes Pharmacy was suspended",
              "Yesterday",
              "red",
            ],
          ].map(([t, d, time, c]) => (
            <div className="activity" key={t}>
              <i className={`activity-dot ${c}`} />
              <div>
                <b>{t}</b>
                <p>{d}</p>
                <span>{time}</span>
              </div>
            </div>
          ))}
        </section>
      </div>
    </>
  );
}

function MerchantsPage() {
  const [query, setQuery] = useState("");
  const [status, setStatus] = useState("All statuses");
  const filtered = useMemo(
    () =>
      merchants.filter(
        (m) =>
          (m.name.toLowerCase().includes(query.toLowerCase()) ||
            m.id.toLowerCase().includes(query.toLowerCase())) &&
          (status === "All statuses" || m.status === status),
      ),
    [query, status],
  );
  return (
    <>
      <PageHeader
        title="Merchants"
        subtitle="Manage merchant profiles, branches, settlement accounts, and status."
        action={
          <Link href="/merchants/new" className="button primary">
            <Plus /> Add Merchant
          </Link>
        }
      />
      <div className="card table-card">
        <div className="toolbar">
          <div className="search">
            <Search />
            <input
              placeholder="Search by name or merchant ID"
              value={query}
              onChange={(e) => setQuery(e.target.value)}
            />
          </div>
          <select value={status} onChange={(e) => setStatus(e.target.value)}>
            <option>All statuses</option>
            <option>Active</option>
            <option>Suspended</option>
            <option>Pending</option>
          </select>
          <button className="button outline">
            <Filter /> Filters
          </button>
          <button
            className="clear"
            onClick={() => {
              setQuery("");
              setStatus("All statuses");
            }}
          >
            Clear
          </button>
        </div>
        <div className="table-scroll">
          <table>
            <thead>
              <tr>
                <th>Merchant ID</th>
                <th>Business name</th>
                <th>Category</th>
                <th>Contact</th>
                <th>Branches</th>
                <th>Settlement account</th>
                <th>Status</th>
                <th>Created</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {filtered.map((m) => (
                <tr key={m.id}>
                  <td>
                    <Link className="id-link" href={`/merchants/${m.id}`}>
                      {m.id}
                    </Link>
                  </td>
                  <td>
                    <div className="table-name">
                      <div className="merchant-avatar">
                        {m.name.slice(0, 2)}
                      </div>
                      <div>
                        <b>{m.name}</b>
                        <span>{m.type}</span>
                      </div>
                    </div>
                  </td>
                  <td>{m.category}</td>
                  <td>{m.phone}</td>
                  <td>{m.branches}</td>
                  <td>
                    <span className="account">
                      <WalletCards /> {m.account}
                    </span>
                  </td>
                  <td>
                    <Status value={m.status} />
                  </td>
                  <td>{m.date}</td>
                  <td>
                    <button className="icon-button">
                      <MoreHorizontal />
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="table-footer">
          <span>Showing {filtered.length} of 1,248 merchants</span>
          <div>
            <button className="pagination">‹</button>
            <button className="pagination current">1</button>
            <button className="pagination">2</button>
            <button className="pagination">3</button>
            <button className="pagination">›</button>
          </div>
        </div>
      </div>
    </>
  );
}

function GenericPage({ type }: { type: "categories" | "fees" | "branches" }) {
  const isCat = type === "categories";
  const isFee = type === "fees";
  const title = isCat
    ? "Merchant categories"
    : isFee
      ? "Fee profiles"
      : "Branches";
  const sub = isCat
    ? "Classify and organize merchants across your network."
    : isFee
      ? "Manage transaction pricing and settlement frequency."
      : "Monitor branches across all merchants.";
  const rows = isCat
    ? categories
    : isFee
      ? fees
      : merchants.map((m) => [
          m.id + "-01",
          m.name + " Main Branch",
          "Addis Ababa",
          m.phone,
          m.status,
          m.date,
        ]);
  return (
    <>
      <PageHeader
        title={title}
        subtitle={sub}
        action={
          <button className="button primary">
            <Plus />{" "}
            {isCat
              ? "Add category"
              : isFee
                ? "Create fee profile"
                : "Add branch"}
          </button>
        }
      />
      <div className="card table-card">
        <div className="toolbar">
          <div className="search">
            <Search />
            <input placeholder={`Search ${title.toLowerCase()}`} />
          </div>
          <button className="button outline">
            <Filter /> Filters
          </button>
        </div>
        <div className="table-scroll">
          <table>
            <thead>
              <tr>
                {(isCat
                  ? [
                      "Category code",
                      "Category name",
                      "Description",
                      "Merchants",
                      "Status",
                      "",
                    ]
                  : isFee
                    ? [
                        "Profile name",
                        "Description",
                        "Transaction fee",
                        "Settlement",
                        "Assigned",
                        "Status",
                      ]
                    : [
                        "Branch code",
                        "Branch name",
                        "City",
                        "Phone",
                        "Status",
                        "Created",
                      ]
                ).map((x) => (
                  <th key={x}>{x}</th>
                ))}
              </tr>
            </thead>
            <tbody>
              {rows.map((r: any[], i) => (
                <tr key={i}>
                  {r.map((x, j) => (
                    <td key={j}>
                      {j === (isCat ? 4 : isFee ? 5 : 4) ? (
                        <Status value={x} />
                      ) : j === 0 && (isCat || isFee) ? (
                        <b>{x}</b>
                      ) : (
                        x
                      )}
                    </td>
                  ))}
                  <td>
                    <button className="icon-button">
                      <MoreHorizontal />
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}

function DetailPage() {
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

function Onboarding() {
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

export function MerchantApp() {
  const path = usePathname() || "/";
  const [open, setOpen] = useState(false);
  const [notificationsOpen, setNotificationsOpen] = useState(false);
  const [notificationsExpanded, setNotificationsExpanded] = useState(false);
  const [notificationsUnread, setNotificationsUnread] = useState(true);
  const [addMerchantOpen, setAddMerchantOpen] = useState(false);
  const notificationRef = useRef<HTMLDivElement>(null);
  const goToOnboarding = () => {
    window.location.href = "/merchants/new";
  };
  useEffect(() => {
    if (!notificationsOpen) return;
    const handlePointerDown = (event: PointerEvent) => {
      if (
        notificationRef.current &&
        !notificationRef.current.contains(event.target as Node)
      )
        setNotificationsOpen(false);
    };
    document.addEventListener("pointerdown", handlePointerDown);
    return () => document.removeEventListener("pointerdown", handlePointerDown);
  }, [notificationsOpen]);
  let content =
    path === "/merchants" ? (
      <MerchantsPage />
    ) : path === "/merchants/new" ? (
      <Onboarding />
    ) : path.includes("/merchants/MER-000001/branches") ? (
      <GenericPage type="branches" />
    ) : path.startsWith("/merchants/MER-000001") ? (
      <DetailPage />
    ) : path === "/merchant-categories" ? (
      <GenericPage type="categories" />
    ) : path === "/fee-profiles" ? (
      <GenericPage type="fees" />
    ) : (
      <Dashboard onAddMerchant={() => setAddMerchantOpen(true)} />
    );
  return (
    <div className="app-shell">
      <Sidebar open={open} setOpen={setOpen} />
      <main className="main">
        <header className="topbar">
          <div className="breadcrumbs">
            <span>POSMS</span>
            <b>/</b>
            <strong>
              {path === "/merchants"
                ? "Merchants"
                : path === "/"
                  ? "Dashboard"
                  : "Merchant operations"}
            </strong>
          </div>
          <div className="top-actions">
            <div className="global-search">
              <Search />
              <input placeholder="Search anything..." />
            </div>
            <div className="notification-wrap" ref={notificationRef}>
              <button
                className="notification"
                aria-label="Notifications"
                aria-expanded={notificationsOpen}
                onClick={() => setNotificationsOpen(!notificationsOpen)}
              >
                <Bell />
                <i />
              </button>
              {notificationsOpen && (
                <div
                  className="notification-menu"
                  onClick={(event) => {
                    const target = event.target as HTMLElement;
                    const label = target.closest("button")?.textContent?.trim();
                    if (label === "Mark all read") {
                      setNotificationsUnread(false);
                    }
                    if (label === "View all") {
                      setNotificationsExpanded(true);
                    }
                    if (label === "View less") {
                      setNotificationsExpanded(false);
                    }
                  }}
                >
                  <div className="menu-heading">
                    <div>
                      <b>Notifications</b>
                      <span>
                        {notificationsUnread
                          ? "3 unread updates"
                          : "All caught up"}
                      </span>
                    </div>
                    <button onClick={() => setNotificationsUnread(false)}>
                      Mark all read
                    </button>
                  </div>
                  <div className="notification-item">
                    <span className="notification-dot blue" />
                    <div>
                      <b>New merchant submitted</b>
                      <p>Swift Ride Ethiopia is ready for review.</p>
                      <small>12 minutes ago</small>
                    </div>
                  </div>
                  <div className="notification-item">
                    <span className="notification-dot amber" />
                    <div>
                      <b>Settlement account needs attention</b>
                      <p>Review the account details for ABC Trading PLC.</p>
                      <small>1 hour ago</small>
                    </div>
                  </div>
                  <div className="notification-item">
                    <span className="notification-dot green" />
                    <div>
                      <b>Onboarding completed</b>
                      <p>Addis Fresh Market is now active.</p>
                      <small>Yesterday</small>
                    </div>
                    {notificationsExpanded && (
                      <div className="notification-item">
                        <span className="notification-dot blue" />
                        <div>
                          <b>Fee profile updated</b>
                          <p>Premium fee profile changes are now active.</p>
                          <small>2 days ago</small>
                        </div>
                      </div>
                    )}
                  </div>
                  <button className="view-all">
                    {notificationsExpanded ? "View less" : "View all"}
                  </button>
                </div>
              )}
            </div>
            <div className="top-avatar">NA</div>
          </div>
        </header>
        <div className="content">{content}</div>
      </main>
      {addMerchantOpen && (
        <div
          className="modal-backdrop"
          role="presentation"
          onMouseDown={(e) => {
            if (e.target === e.currentTarget) setAddMerchantOpen(false);
          }}
        >
          <section
            className="merchant-modal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="add-merchant-title"
          >
            <button
              className="modal-close"
              aria-label="Close"
              onClick={() => setAddMerchantOpen(false)}
            >
              <X />
            </button>
            <div className="modal-icon">
              <Store />
            </div>
            <h2 id="add-merchant-title">Add a new merchant</h2>
            <p>
              Start onboarding a business and configure its merchant services.
            </p>
            <div className="modal-options">
              <button onClick={goToOnboarding}>
                <span>
                  <Plus />
                </span>
                <div>
                  <b>Create merchant profile</b>
                  <small>
                    Enter business, contact, settlement, and fee details.
                  </small>
                </div>
                <ArrowUpRight />
              </button>
              <button onClick={() => setAddMerchantOpen(false)}>
                <span>
                  <Users />
                </span>
                <div>
                  <b>Import merchants</b>
                  <small>Upload a prepared list of merchant profiles.</small>
                </div>
                <ArrowUpRight />
              </button>
            </div>
            <button
              className="button ghost modal-cancel"
              onClick={() => setAddMerchantOpen(false)}
            >
              Cancel
            </button>
          </section>
        </div>
      )}
    </div>
  );
}
