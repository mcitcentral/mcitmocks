import axios from "axios";

axios.defaults.baseURL = "/api";

const apiClient = {
  getTestData: async () => {
    const { data } = await axios.get("/test");
    return data;
  },
};

export default apiClient;
