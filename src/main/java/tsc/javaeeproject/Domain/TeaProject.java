package tsc.javaeeproject.Domain;

public class TeaProject {
    public int tea_id,p_id;
    public String id_header,is_confirm,is_mid_confirm,mid_suggestion,is_res_confirm,res_suggestion,suggestion;

    public TeaProject() {
    }

    @Override
    public String toString() {
        return "TeaProject{" +
                "tea_id=" + tea_id +
                ", p_id=" + p_id +
                ", id_header='" + id_header + '\'' +
                ", is_confirm='" + is_confirm + '\'' +
                ", is_mid_confirm='" + is_mid_confirm + '\'' +
                ", mid_suggestion='" + mid_suggestion + '\'' +
                ", is_res_confirm='" + is_res_confirm + '\'' +
                ", res_suggestion='" + res_suggestion + '\'' +
                ", suggestion='" + suggestion + '\'' +
                '}';
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getId_header() {
        return id_header;
    }

    public void setId_header(String id_header) {
        this.id_header = id_header;
    }

    public String getIs_confirm() {
        return is_confirm;
    }

    public void setIs_confirm(String is_confirm) {
        this.is_confirm = is_confirm;
    }

    public String getIs_mid_confirm() {
        return is_mid_confirm;
    }

    public void setIs_mid_confirm(String is_mid_confirm) {
        this.is_mid_confirm = is_mid_confirm;
    }

    public String getMid_suggestion() {
        return mid_suggestion;
    }

    public void setMid_suggestion(String mid_suggestion) {
        this.mid_suggestion = mid_suggestion;
    }

    public String getIs_res_confirm() {
        return is_res_confirm;
    }

    public void setIs_res_confirm(String is_res_confirm) {
        this.is_res_confirm = is_res_confirm;
    }

    public String getRes_suggestion() {
        return res_suggestion;
    }

    public void setRes_suggestion(String res_suggestion) {
        this.res_suggestion = res_suggestion;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public TeaProject(int tea_id, int p_id, String id_header, String is_confirm, String is_mid_confirm, String mid_suggestion, String is_res_confirm, String res_suggestion, String suggestion) {
        this.tea_id = tea_id;
        this.p_id = p_id;
        this.id_header = id_header;
        this.is_confirm = is_confirm;
        this.is_mid_confirm = is_mid_confirm;
        this.mid_suggestion = mid_suggestion;
        this.is_res_confirm = is_res_confirm;
        this.res_suggestion = res_suggestion;
        this.suggestion = suggestion;
    }
}
