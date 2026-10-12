import { useState } from "react";
import { usePathname } from "@/components/use-path-name";
import { Link } from "@/utils/link";
import {
  Activity,
  Building2,
  ChevronDown,
  CreditCard,
  LayoutDashboard,
  Menu,
  MoreHorizontal,
  Settings,
  ShieldCheck,
  Store,
  Tag,
  WalletCards,
  Check,
  CircleDollarSign,
  ArrowDownToLine,
  BarChart3,
  CalendarDays,
} from "lucide-react";

export const Sidebar = ({
  open,
  setOpen,
  selectedWorkspace,
  setSelectedWorkspace,
}: any) => {
  const path = usePathname();
  const [workspaceOpen, setWorkspaceOpen] = useState(false);
  const links =
    selectedWorkspace.initials === "TW"
      ? [
          ["/", "Terminal overview", LayoutDashboard],
          ["/merchants", "Terminal fleet", CreditCard],
          ["/branches", "Locations", Building2],
          ["/settings", "Device settings", Settings],
        ]
      : selectedWorkspace.initials === "TX"
        ? [
            ["/", "Transactions", Activity],
            ["/merchants", "Payment activity", CircleDollarSign],
            ["/branches", "Refunds", ArrowDownToLine],
            ["/settlement-accounts", "Settlements", WalletCards],
            ["/settings", "Transaction settings", Settings],
          ]
        : selectedWorkspace.initials === "RP"
          ? [
              ["/", "Analytics overview", BarChart3],
              ["/merchants", "Merchant performance", Store],
              ["/branches", "Scheduled reports", CalendarDays],
              ["/settings", "Report settings", Settings],
            ]
          : [
              ["/", "Dashboard", LayoutDashboard],
              ["/merchants", "Merchants", Store],
              ["/branches", "Branches", Building2],
              ["/merchant-categories", "Merchant Categories", Tag],
              ["/fee-profiles", "Fee Profiles", CreditCard],
              ["/settlement-accounts", "Settlement Accounts", WalletCards],
              ["/settings", "Settings", Settings],
            ];

  const workspaces = [
    ["Merchant Services", "Operations workspace", "MS"],
    ["Terminal Services", "Terminal operations", "TW"],
    ["Transactions Services", "Payments and transaction activity", "TX"],
    ["Reports Services", "Analytics and reporting", "RP"],
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
            <b>meridian</b>
            <span className="uppercase">{selectedWorkspace.name}</span>
          </div>
        </div>
        <div className="workspace-switcher">
          <button
            className="workspace"
            onClick={() => setWorkspaceOpen(!workspaceOpen)}
            aria-expanded={workspaceOpen}
            aria-haspopup="menu"
          >
            <div className="workspace-avatar">{selectedWorkspace.initials}</div>
            <div>
              <b>{selectedWorkspace.name}</b>
              <span>{selectedWorkspace.description}</span>
            </div>
            <ChevronDown />
          </button>
          {workspaceOpen && (
            <div className="workspace-menu" role="menu">
              {workspaces.map(([name, description, initials]) => (
                <button
                  key={name}
                  className={
                    name === selectedWorkspace.name
                      ? "workspace-option selected"
                      : "workspace-option"
                  }
                  role="menuitem"
                  onClick={() => {
                    setSelectedWorkspace({ name, description, initials });
                    setWorkspaceOpen(false);
                  }}
                >
                  <div className="workspace-avatar">{initials}</div>
                  <div>
                    <b>{name}</b>
                    <span>{description}</span>
                  </div>
                  {name === selectedWorkspace.name && <Check />}
                </button>
              ))}
            </div>
          )}
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
              onClick={() => {
                setOpen(false);
                setWorkspaceOpen(false);
              }}
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
};
