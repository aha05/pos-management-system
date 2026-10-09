import { merchants, categories, fees }  from "@/data/data";
import { PageHeader }  from "@/components/page-header";
import { Status }  from "@/components/ui/status";

import {
  Filter,
  MoreHorizontal,
  Plus,
  Search,
} from "lucide-react";

export const GenericPage = ({ type }: { type: "categories" | "fees" | "branches" }) => {
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