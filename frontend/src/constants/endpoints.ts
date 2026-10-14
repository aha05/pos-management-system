export const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || "http://localhost:8080";

export const API_ENDPOINTS = {
  merchant: "/merchant",
  merchantById: (id: number) => `/merchant/${id}`,
  createMerchant: "/merchant/create",
  categories: "/merchant/category",
  feeProfiles: "/fee-profile",
  addContactPerson: "/merchant/contact/create",
  addSettlementAccount: "/settlement-account-reference/create",
  addMerchantDocument: "/merchant/document/create",
} as const;
