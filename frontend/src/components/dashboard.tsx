import { Metric }  from "@/components/ui/metric";
import { Status }  from "@/components/ui/status";
import { PageHeader }  from "@/components/page-header";
import { merchants }  from "@/data/data";
import { Link }  from "@/utils/Link";


import {
  ArrowUpRight,
  Building2,
  ChevronDown,
  MoreHorizontal,
  Store,
  ShieldCheck,
  FileText,
} from "lucide-react";

export const Dashboard = ({ onAddMerchant }: { onAddMerchant: () => void }) => {
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