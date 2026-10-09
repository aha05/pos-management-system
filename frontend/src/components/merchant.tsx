import { useMemo, useState } from "react";
import {
  Filter,
  MoreHorizontal,
  Plus,
  Search,
  WalletCards,
} from "lucide-react";
import { Status }  from "@/components/ui/status";
import { PageHeader }  from "@/components/page-header";
import { merchants }  from "@/data/data";
import { Link }  from "@/utils/Link";



export const MerchantsPage = () => {
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