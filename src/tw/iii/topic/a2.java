package tw.iii.topic;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class a
 */
@WebServlet("/a2")
public class a2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password","root");
		
		
		
		
		
		  try {
			  
			  Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost/tourism?useUnicode=true&characterEncoding=utf-8",prop);
				String sql ="INSERT INTO `hostel`(`Gid`, `Name`, `Zone`, `Toldescribe`, `Description`, `Tel`, `Add`, `Zipcode`, `Travellinginfo`, `Opentime`, `Picture1`, `Picdescribe1`, `Picture2`, `Picdescribe2`, `Picture3`, `Picdescribe3`, `Map`, `Gov`, `Px`, `Py`, `Orgclass`, `Class1`, `Class2`, `Class3`, `Level`, `Website`, `Parkinginfo`, `Parkinginfo_px`, `Parkinginfo_py`, `Ticketinfo`, `Remarks`, `Keyword`, `Changetime`)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			  
			  
			  
			  File fXmlFile = new File("C:\\Users\\Mac\\Desktop\\hotel_C_f.xml");
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(fXmlFile);
			  
			  //optional, but recommended
			  //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			  doc.getDocumentElement().normalize();
			  
			 
			  NodeList nList = doc.getElementsByTagName("Info");
			  
			  System.out.println("----------------------------");
			  
			  for (int temp = 0; temp < nList.getLength(); temp++) {
			  
			   Node nNode = nList.item(temp);
			  
			   System.out.println("\nCurrent Element :" + nNode.getNodeName());
			  
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			  
			    Element eElement = (Element) nNode;
			    
			    
			    System.out.println(eElement.getAttribute("Picdescribe1"));
			    
			    pstmt.setString(1, eElement.getAttribute("Id"));
				pstmt.setString(2,eElement.getAttribute("Name"));
				pstmt.setString(3, eElement.getAttribute("Zone"));
				pstmt.setString(4, eElement.getAttribute("Toldescribe"));
				pstmt.setString(5, eElement.getAttribute("Description"));
				pstmt.setString(6, eElement.getAttribute("Tel"));
				pstmt.setString(7, eElement.getAttribute("Add"));
				pstmt.setString(8, eElement.getAttribute("Zipcode"));
				pstmt.setString(9, eElement.getAttribute("Travellinginfo"));
				pstmt.setString(10, eElement.getAttribute("Opentime"));
				pstmt.setString(11, eElement.getAttribute("Picture1"));
				pstmt.setString(12, eElement.getAttribute("Picdescribe1"));
				pstmt.setString(13, eElement.getAttribute("Picture2"));
				pstmt.setString(14, eElement.getAttribute("Picdescribe2"));
				pstmt.setString(15, eElement.getAttribute("Picture3"));
				pstmt.setString(16, eElement.getAttribute("Picdescribe3"));
				pstmt.setString(17, eElement.getAttribute("Map"));
				pstmt.setString(18, eElement.getAttribute("Gov"));
				pstmt.setString(19, eElement.getAttribute("Px"));
				pstmt.setString(20, eElement.getAttribute("Py"));
				pstmt.setString(21, eElement.getAttribute("Orgclass"));
				pstmt.setString(22, eElement.getAttribute("Class1"));
				pstmt.setString(23, eElement.getAttribute("Class2"));
				pstmt.setString(24, eElement.getAttribute("Class3"));
				pstmt.setString(25, eElement.getAttribute("Level"));
				pstmt.setString(26, eElement.getAttribute("Website"));
				pstmt.setString(27, eElement.getAttribute("Parkinginfo"));
				pstmt.setString(28, eElement.getAttribute("Parkinginfo_px"));
				pstmt.setString(29, eElement.getAttribute("Parkinginfo_py"));
				pstmt.setString(30, eElement.getAttribute("Ticketinfo"));
				pstmt.setString(31, eElement.getAttribute("Remarks"));
				pstmt.setString(32, eElement.getAttribute("Keyword"));
				pstmt.setString(33, eElement.getAttribute("Changetime"));
				
				
				pstmt.execute();
			   }
			  }
			  System.out.println("OK");
			     } catch (Exception e) {
			  e.printStackTrace();
			     }
		
	}
}
