package tw.iii.topic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class dataadd
 */
@WebServlet("/dataadd")
public class dataadd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strURL="http://gis.taiwan.net.tw/XMLReleaseALL_public/scenic_spot_C_f.json";
		String json = getJSONString();
		//帳號密碼資料庫位置設定
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password","root");
		
		
		
		try {
			//sql驅動程式載入
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/attractions?",prop);
			String sql ="INSERT INTO tourism"
					+ "(GID,Name,Zone,Toldescribe,Description,Tel,Add,Zipcode,Travellinginfo,Opentime,Picture1,Picdescribe1,"
					+ "Picture2,Picdescribe2,Picture3,Picdescribe3,Map,Gov,Px,Py,Orgclass,Class1,Class2,Class3,Level,Website"
					+ "Parkinginfo,Parkinginfo_px,Parkinginfo_py,Ticketinfo,Remarks,Keyword,Changetime)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			JSONArray root = new JSONArray(json);
			for(int i = 0; i < root.length();i++) {
				JSONObject row = root.getJSONObject(i);
				String gid = row.getString("ID");
				String Name = row.getString("Name");
				String Zone = row.getString("Zone");
				String Toldescribe = row.getString("Toldescribe");
				String Description = row.getString("Description");
				String Tel = row.getString("Tel");
				String Add = row.getString("Add");
				String Zipcode = row.getString("Zipcode");
				String Travellinginfo = row.getString("Travellinginfo");
				String Opentime = row.getString("Opentime");
				String Picture1 = row.getString("Picture1");
				String Picdescribe1 = row.getString("Picdescribe1");
				String Picture2 = row.getString("Picture2");
				String Picdescribe2 = row.getString("Picdescribe2");
				String Picture3 = row.getString("Picture3");
				String Picdescribe3 = row.getString("Picdescribe3");
				String Map = row.getString("Map");
				String Gov = row.getString("Gov");
				String Px = row.getString("Px");
				String Py = row.getString("Py");
				String Orgclass = row.getString("Orgclass");
				String Class1 = row.getString("Class1");
				String Class2 = row.getString("Class2");
				String Class3 = row.getString("Class3");
				String Level = row.getString("Level");
				String Website = row.getString("Website");
				String Parkinginfo = row.getString("Parkinginfo");
				String Parkinginfo_px = row.getString("Parkinginfo_px");
				String Parkinginfo_py = row.getString("Parkinginfo_py");
				String Ticketinfo = row.getString("Ticketinfo");
				String Remarks = row.getString("Remarks");
				String Keyword = row.getString("Keyword");
				String Changetime = row.getString("Changetime");
				
				//
				pstmt.setString(1, gid);
				pstmt.setString(2, Name);
				pstmt.setString(3, Zone);
				pstmt.setString(4, Toldescribe);
				pstmt.setString(5, Description);
				pstmt.setString(6, Tel);
				pstmt.setString(7, Add);
				pstmt.setString(8, Zipcode);
				pstmt.setString(9, Travellinginfo);
				pstmt.setString(10, Opentime);
				pstmt.setString(11, Picture1);
				pstmt.setString(12, Picdescribe1);
				pstmt.setString(13, Picture2);
				pstmt.setString(14, Picdescribe2);
				pstmt.setString(15, Picture3);
				pstmt.setString(16, Picdescribe3);
				pstmt.setString(17, Map);
				pstmt.setString(18, Gov);
				pstmt.setString(19, Px);
				pstmt.setString(20, Py);
				pstmt.setString(21, Orgclass);
				pstmt.setString(22, Class1);
				pstmt.setString(23, Class2);
				pstmt.setString(24, Class3);
				pstmt.setString(25, Level);
				pstmt.setString(26, Website);
				pstmt.setString(27, Parkinginfo);
				pstmt.setString(28, Parkinginfo_px);
				pstmt.setString(29, Parkinginfo_py);
				pstmt.setString(30, Ticketinfo);
				pstmt.setString(31, Remarks);
				pstmt.setString(32, Keyword);
				pstmt.setString(33, Changetime);
				
				pstmt.execute();
				System.out.println("OK");
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	//取得網頁JSON格式
	private static String getJSONString() {
		StringBuilder sb  = new StringBuilder();
		try {
			//初始化URL
//			URL url = new URL(strURL);
//			//取得連線物件
//			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//			//連接
//			connection.connect();
			//串流
			BufferedReader reader = new BufferedReader(
					new FileReader("D:\\J2EE\\workspace\\tourism\\test2.txt"));
			//讀取
			String tmpstr;
			while((tmpstr=reader.readLine())!=null ) {
				sb.append(tmpstr);
			}
			//關閉串流
			reader.close();
//			System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e);
		}
		return sb.toString();
	}
}
