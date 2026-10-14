import api from "@/api/axios";
import { API_ENDPOINTS } from "@/constants/endpoints";

export interface FeeProfile {
  id: number;
  profileCode: string;
  profileName: string;
  transactionFeeType: string;
  transactionFee: number;
  minimumFee: number;
  maximumFee: number | null;
  settlementFeeType: string;
  settlementFeeValue: number;
  currency: string;
  active: boolean;
}

export const feeProfileService = {
  getAll: async (): Promise<FeeProfile[]> => {
    const response = await api.get<FeeProfile[]>(API_ENDPOINTS.feeProfiles);
    return response.data;
  },
};
