import api from "@/api/axios";
import { API_ENDPOINTS } from "@/constants/endpoints";

// Merchant
export interface MerchantRequest {
  merchantCode: string;
  legalName: string;
  tradeName: string;
  businessLicense: string;
  tinNumber: string;
  businessType: string;
  merchantCategoryId: number;
  feeProfileId: number;
  status: string;
  phoneNumber: string;
  email: string;
  website: string;
  country: string;
  city: string;
  subCity: string;
  woreda: string;
  address: string;
  houseNo: string;
}

export interface Merchant extends MerchantRequest {
  id: number;
}

// Contact Person
export interface ContactPersonRequest {
    merchantId: number;
    fullName: string;
    designation: string;
    phoneNumber: string;
    email: string;
    primaryContact: boolean;

}

export interface ContactPerson extends ContactPersonRequest {
    id: number;
}

// Settlement Account
export interface SettlementAccountRequest {
    merchantId: number;
    accountNumber: string;
    accountHolderName: string;
    bankName: string;
    bankCode: string;
    currency: string;
    accountServiceReferenceId: string;
    isPrimary: boolean;
    active: boolean;

}

export interface SettlementAccount extends SettlementAccountRequest {
    id: number;
}

// Merchant Document
export interface MerchantDocumentRequest {
    merchantId: number;
    documentType: string;
    fileName: string
    storagePath: string
    verified: boolean
}

export interface MerchantDocument extends MerchantDocumentRequest {
   id: number;
}



export const merchantService = {
  getAll: async (): Promise<Merchant[]> => {
    const response = await api.get<Merchant[]>(API_ENDPOINTS.merchant);
    return response.data;
  },

  getById: async (id: number): Promise<Merchant> => {
    const response = await api.get<Merchant>(API_ENDPOINTS.merchantById(id));
    return response.data;
  },

  createMerchant: async (data: MerchantRequest): Promise<Merchant> => {
    const response = await api.post<Merchant>(API_ENDPOINTS.createMerchant, data);
    return response.data;
  },

  // Contact Person
  addContactPerson: async (data: ContactPersonRequest): Promise<ContactPerson> => {
    const response = await api.post<ContactPerson>(API_ENDPOINTS.addContactPerson, data);
    return response.data;
  },

   // Settlement Account
   addSettlementAccount: async (data: SettlementAccountRequest): Promise<SettlementAccount> => {
    const response = await api.post<SettlementAccount>(API_ENDPOINTS.addSettlementAccount, data);
    return response.data;
  },

  // Merchant Document
   addMerchantDocument: async (data: MerchantDocumentRequest): Promise<MerchantDocument> => {
    const response = await api.post<MerchantDocument>(API_ENDPOINTS.addMerchantDocument, data);
    return response.data;
  },
};
