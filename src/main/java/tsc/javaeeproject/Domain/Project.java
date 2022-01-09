package tsc.javaeeproject.Domain;

public class Project {
    public int p_id,money,material_m,print_m,vehicle_m,publish_m,express_m;
    public String p_name,p_type,subjecttype,begintime,endtime,p_info,header_info,member_info,meaning,method,creative,pre_result,p_period,submit_report,mid_report,res_report,submit_score,mid_score,res_score,is_delete;

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Project{" +
                "p_id=" + p_id +
                ", money=" + money +
                ", material_m=" + material_m +
                ", print_m=" + print_m +
                ", vehicle_m=" + vehicle_m +
                ", publish_m=" + publish_m +
                ", express_m=" + express_m +
                ", p_name='" + p_name + '\'' +
                ", p_type='" + p_type + '\'' +
                ", subjecttype='" + subjecttype + '\'' +
                ", begintime='" + begintime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", p_info='" + p_info + '\'' +
                ", header_info='" + header_info + '\'' +
                ", member_info='" + member_info + '\'' +
                ", meaning='" + meaning + '\'' +
                ", method='" + method + '\'' +
                ", creative='" + creative + '\'' +
                ", pre_result='" + pre_result + '\'' +
                ", p_period='" + p_period + '\'' +
                ", submit_report='" + submit_report + '\'' +
                ", mid_report='" + mid_report + '\'' +
                ", res_report='" + res_report + '\'' +
                ", submit_score='" + submit_score + '\'' +
                ", mid_score='" + mid_score + '\'' +
                ", res_score='" + res_score + '\'' +
                ", is_delete='" + is_delete + '\'' +
                '}';
    }

    public Project() {
    }

    public Project(int p_id, int money, int material_m, int print_m, int vehicle_m, int publish_m, int express_m, String p_name, String p_type, String subjecttype, String begintime, String endtime, String p_info, String header_info, String member_info, String meaning, String method, String creative, String pre_result, String p_period, String submit_report, String mid_report, String res_report, String submit_score, String mid_score, String res_score) {
        this.p_id = p_id;
        this.money = money;
        this.material_m = material_m;
        this.print_m = print_m;
        this.vehicle_m = vehicle_m;
        this.publish_m = publish_m;
        this.express_m = express_m;
        this.p_name = p_name;
        this.p_type = p_type;
        this.subjecttype = subjecttype;
        this.begintime = begintime;
        this.endtime = endtime;
        this.p_info = p_info;
        this.header_info = header_info;
        this.member_info = member_info;
        this.meaning = meaning;
        this.method = method;
        this.creative = creative;
        this.pre_result = pre_result;
        this.p_period = p_period;
        this.submit_report = submit_report;
        this.mid_report = mid_report;
        this.res_report = res_report;
        this.submit_score = submit_score;
        this.mid_score = mid_score;
        this.res_score = res_score;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMaterial_m() {
        return material_m;
    }

    public void setMaterial_m(int material_m) {
        this.material_m = material_m;
    }

    public int getPrint_m() {
        return print_m;
    }

    public void setPrint_m(int print_m) {
        this.print_m = print_m;
    }

    public int getVehicle_m() {
        return vehicle_m;
    }

    public void setVehicle_m(int vehicle_m) {
        this.vehicle_m = vehicle_m;
    }

    public int getPublish_m() {
        return publish_m;
    }

    public void setPublish_m(int publish_m) {
        this.publish_m = publish_m;
    }

    public int getExpress_m() {
        return express_m;
    }

    public void setExpress_m(int express_m) {
        this.express_m = express_m;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public String getSubjecttype() {
        return subjecttype;
    }

    public void setSubjecttype(String subjecttype) {
        this.subjecttype = subjecttype;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getP_info() {
        return p_info;
    }

    public void setP_info(String p_info) {
        this.p_info = p_info;
    }

    public String getHeader_info() {
        return header_info;
    }

    public void setHeader_info(String header_info) {
        this.header_info = header_info;
    }

    public String getMember_info() {
        return member_info;
    }

    public void setMember_info(String member_info) {
        this.member_info = member_info;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCreative() {
        return creative;
    }

    public void setCreative(String creative) {
        this.creative = creative;
    }

    public String getPre_result() {
        return pre_result;
    }

    public void setPre_result(String pre_result) {
        this.pre_result = pre_result;
    }

    public String getP_period() {
        return p_period;
    }

    public void setP_period(String p_period) {
        this.p_period = p_period;
    }

    public String getSubmit_report() {
        return submit_report;
    }

    public void setSubmit_report(String submit_report) {
        this.submit_report = submit_report;
    }

    public String getMid_report() {
        return mid_report;
    }

    public void setMid_report(String mid_report) {
        this.mid_report = mid_report;
    }

    public String getRes_report() {
        return res_report;
    }

    public void setRes_report(String res_report) {
        this.res_report = res_report;
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
