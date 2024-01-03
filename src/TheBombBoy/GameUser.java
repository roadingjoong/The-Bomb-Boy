package TheBombBoy;

public class GameUser {
	
	String userid;
	String userpw;
	String username;
	
	int userlevel;
	String useralias;
	
	int userStage;
	int usercoin;
	int useravatar;
	
	public GameUser() { }
	
	public GameUser(String userid, String userpw, String username, int userlevel, String useralias, int userStage,
			int usercoin, int useravatar) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userlevel = userlevel;
		this.useralias = useralias;
		this.userStage = userStage;
		this.usercoin = usercoin;
		this.useravatar = useravatar;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public String getUseralias() {
		return useralias;
	}
	public void setUseralias(String useralias) {
		this.useralias = useralias;
	}
	public int getUserStage() {
		return userStage;
	}
	public void setUserStage(int userStage) {
		this.userStage = userStage;
	}
	public int getUsercoin() {
		return usercoin;
	}
	public void setUsercoin(int usercoin) {
		this.usercoin = usercoin;
	}
	public int getUseravatar() {
		return useravatar;
		
	}
	public void setUseravatar(int useravatar) {
		this.useravatar = useravatar;
	}
	
}
