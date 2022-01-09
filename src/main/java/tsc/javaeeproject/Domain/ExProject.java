package tsc.javaeeproject.Domain;

public class ExProject {
    public int ex_id,p_id;
    public String is_submit_score,submit_suggestion,mid_suggestion,res_suggestion,is_mid_score,is_res_score,submit_score,mid_score,res_score;

    public ExProject() {

    }

    @Override
    public String toString() {
        return "ExProject{" +
                "ex_id=" + ex_id +
                ", p_id=" + p_id +
                ", is_submit_score='" + is_submit_score + '\'' +
                ", submit_suggestion='" + submit_suggestion + '\'' +
                ", mid_suggestion='" + mid_suggestion + '\'' +
                ", res_suggestion='" + res_suggestion + '\'' +
                ", is_mid_score='" + is_mid_score + '\'' +
                ", is_res_score='" + is_res_score + '\'' +
                ", submit_score='" + submit_score + '\'' +
                ", mid_score='" + mid_score + '\'' +
                ", res_score='" + res_score + '\'' +
                '}';
    }

    public ExProject(int ex_id, int p_id, String is_submit_score, String submit_suggestion, String mid_suggestion, String res_suggestion, String is_mid_score, String is_res_score, String submit_score, String mid_score, String res_score) {
        this.ex_id = ex_id;
        this.p_id = p_id;
        this.is_submit_score = is_submit_score;
        this.submit_suggestion = submit_suggestion;
        this.mid_suggestion = mid_suggestion;
        this.res_suggestion = res_suggestion;
        this.is_mid_score = is_mid_score;
        this.is_res_score = is_res_score;
        this.submit_score = submit_score;
        this.mid_score = mid_score;
        this.res_score = res_score;
    }

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getIs_submit_score() {
        return is_submit_score;
    }

    public void setIs_submit_score(String is_submit_score) {
        this.is_submit_score = is_submit_score;
    }

    public String getSubmit_suggestion() {
        return submit_suggestion;
    }

    public void setSubmit_suggestion(String submit_suggestion) {
        this.submit_suggestion = submit_suggestion;
    }

    public String getMid_suggestion() {
        return mid_suggestion;
    }

    public void setMid_suggestion(String mid_suggestion) {
        this.mid_suggestion = mid_suggestion;
    }

    public String getRes_suggestion() {
        return res_suggestion;
    }

    public void setRes_suggestion(String res_suggestion) {
        this.res_suggestion = res_suggestion;
    }

    public String getIs_mid_score() {
        return is_mid_score;
    }

    public void setIs_mid_score(String is_mid_score) {
        this.is_mid_score = is_mid_score;
    }

    public String getIs_res_score() {
        return is_res_score;
    }

    public void setIs_res_score(String is_res_score) {
        this.is_res_score = is_res_score;
    }

    public String getSubmit_score() {
        return submit_score;
    }

    public void setSubmit_score(String submit_score) {
        this.submit_score = submit_score;
    }

    public String getMid_score() {
        return mid_score;
    }

    public void setMid_score(String mid_score) {
        this.mid_score = mid_score;
    }

    public String getRes_score() {
        return res_score;
    }

    public void setRes_score(String res_score) {
        this.res_score = res_score;
    }
}
