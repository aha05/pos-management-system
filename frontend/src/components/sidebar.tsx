import  { usePathname }  from "@/components/use-path-name";
import { Link }  from "@/utils/Link";
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
} from "lucide-react";


export const Sidebar = ({ open, setOpen }: any) => {
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