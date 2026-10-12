import { PageHeader }  from "@/components/page-header";
import { Metric }  from "@/components/ui/metric";
import {
  ArrowUpRight,
  Building2,
  MoreHorizontal,
  ShieldCheck,
  FileText,
  CircleDollarSign,
  BarChart3,
  WalletCards,
  Check,
  CreditCard,
  Activity,
  CalendarDays,
} from "lucide-react"


export const WorkspacePage = ({
  workspace,
}: {
  workspace: "TW" | "TX" | "RP";
}) => {
  const config =
    workspace === "TW"
      ? {
          title: "Terminal operations",
          subtitle:
            "Monitor terminal estate, device health, and deployment activity.",
          metrics: [
            ["Active terminals", "864", "+12.4%", CreditCard, "blue"],
            ["Online now", "812", "+4.8%", Activity, "green"],
            ["Needs attention", "18", "-6.2%", ShieldCheck, "amber"],
            ["Deployment queue", "34", "+9.1%", Building2, "purple"],
          ],
          sections: [
            ["Terminal estate", "864 devices across 126 locations"],
            ["Recent deployments", "34 terminals scheduled for installation"],
            ["Device health", "93.9% of terminals are online"],
          ],
        }
      : workspace === "TX"
        ? {
            title: "Transaction activity",
            subtitle:
              "Track payment volume, success rates, and settlement activity.",
            metrics: [
              [
                "Today’s volume",
                "ETB 2.84M",
                "+14.2%",
                CircleDollarSign,
                "blue",
              ],
              ["Successful payments", "98.6%", "+1.4%", Check, "green"],
              ["Pending review", "42", "-3.8%", FileText, "amber"],
              ["Settlement batches", "18", "+5.6%", WalletCards, "purple"],
            ],
            sections: [
              [
                "Payment performance",
                "Transaction success across your network",
              ],
              ["Latest activity", "Real-time payment and refund events"],
              ["Settlement status", "All scheduled batches are on track"],
            ],
          }
        : {
            title: "Reports and analytics",
            subtitle: "Turn network activity into clear operational insights.",
            metrics: [
              ["Reports generated", "248", "+18.6%", BarChart3, "blue"],
              ["Network growth", "8.2%", "+2.1%", ArrowUpRight, "green"],
              ["Scheduled reports", "16", "+4.0%", CalendarDays, "amber"],
              ["Data freshness", "2 min", "-12.0%", Activity, "purple"],
            ],
            sections: [
              [
                "Performance overview",
                "Compare volume, growth, and merchant health",
              ],
              ["Scheduled reports", "16 reports delivered to your teams"],
              ["Insights", "Explore trends across the network"],
            ],
          };
  return (
    <>
      <PageHeader
        title={config.title}
        subtitle={config.subtitle}
        action={
          <button className="button primary">
            <FileText /> Create report
          </button>
        }
      />
      <div className="metrics">
        {config.metrics.map(([label, value, change, Icon, tone]: any) => (
          <Metric
            key={label}
            label={label}
            value={value}
            change={change}
            icon={Icon}
            tone={tone}
          />
        ))}
      </div>
      <div className="workspace-grid">
        {config.sections.map(([title, subtitle]) => (
          <section className="card workspace-panel" key={title}>
            <div className="card-heading">
              <div>
                <h2>{title}</h2>
                <p>{subtitle}</p>
              </div>
              <MoreHorizontal />
            </div>
            <div className="workspace-panel-body">
              <BarChart3 />
              <span>Updated just now</span>
              <button className="button outline">View details</button>
            </div>
          </section>
        ))}
      </div>
    </>
  );
};
