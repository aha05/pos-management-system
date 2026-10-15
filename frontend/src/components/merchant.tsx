import { useEffect, useMemo, useState } from "react";
import { Filter, MoreHorizontal, Plus, Search, WalletCards } from "lucide-react";
import { Status } from "@/components/ui/status";
import { PageHeader } from "@/components/page-header";
import { merchantService, type MerchantInformation } from "@/services/merchant/merchant.service";
import { Link } from "@/utils/link";

export const MerchantsPage = () => {
  const [merchants, setMerchants] = useState<MerchantInformation[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [query, setQuery] = useState("");
  const [status, setStatus] = useState("All statuses");

  useEffect(() => {
    let isCurrent = true;

    const loadMerchants = async () => {
      try {
        const data = await merchantService.getAllMerchantInfo();
        if (isCurrent) setMerchants(data);
      } catch {
        if (isCurrent) setError("Unable to load merchants. Please try again.");
      } finally {
        if (isCurrent) setLoading(false);
      }
    };

    void loadMerchants();
    return () => {
      isCurrent = false;
    };
  }, []);

  const filtered = useMemo(
    () =>
      merchants.filter(
        (merchant) =>
          (merchant.tradeName.toLowerCase().includes(query.toLowerCase()) ||
            merchant.merchantCode.toLowerCase().includes(query.toLowerCase())) &&
          (status === "All statuses" || merchant.status.toLowerCase() === status.toLowerCase()),
      ),
    [merchants, query, status],
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
              onChange={(event) => setQuery(event.target.value)}
            />
          </div>
          <select value={status} onChange={(event) => setStatus(event.target.value)}>
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
                <th>Merchant Code</th>
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
              {loading && <tr><td colSpan={9}>Loading merchants…</td></tr>}
              {!loading && error && <tr><td colSpan={9}>{error}</td></tr>}
              {!loading && !error && filtered.length === 0 && (
                <tr><td colSpan={9}>No merchants found.</td></tr>
              )}
              {!loading && !error && filtered.map((merchant) => (
                <tr key={merchant.id}>
                  <td>
                    <Link className="id-link" href={`/merchants/${merchant.id}`}>
                      {merchant.merchantCode}
                    </Link>
                  </td>
                  <td>
                    <div className="table-name">
                      <div className="merchant-avatar">{merchant.tradeName.slice(0, 2)}</div>
                      <div>
                        <b>{merchant.tradeName}</b>
                        <span>{merchant.businessType}</span>
                      </div>
                    </div>
                  </td>
                  <td>{merchant.category}</td>
                  <td>{merchant.phoneNumber}</td>
                  <td>{merchant.branch || "—"}</td>
                  <td>
                    <span className="account"><WalletCards /> {merchant.settlementAccount || "—"}</span>
                  </td>
                  <td><Status value={merchant.status} /></td>
                  <td>{new Date(merchant.createdAt).toLocaleDateString()}</td>
                  <td>
                    <button className="icon-button" aria-label={`More actions for ${merchant.tradeName}`}>
                      <MoreHorizontal />
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="table-footer">
          <span>Showing {filtered.length} of {merchants.length} merchants</span>
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
};
