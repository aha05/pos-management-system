import api from "@/api/axios";
import { API_ENDPOINTS } from "@/constants/endpoints";

export interface MerchantCategory {
  id: number;
  categoryCode: string;
  categoryName: string;
  description: string | null;
  active: boolean;
}

export const categoryService = {
  getAll: async (): Promise<MerchantCategory[]> => {
    const response = await api.get<MerchantCategory[]>(API_ENDPOINTS.categories);
    return response.data;
  },
};
