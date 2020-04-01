import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DATABASE_URL = "jdbc:mysql://localhost/test";
    final String USERNAME = "root";
    final String PASSWORD = "123456";

    public TestServlet() {
        super();
    }

    public void init() throws ServletException {
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if have other character
        request.setCharacterEncoding("utf-8");
        // Declaration of the corresponding attribute variable, used to receive form data.
        String username = "";
        String password = "";
        try {
            //get data
            username = request.getParameter("username");
            password = request.getParameter("password");
            System.out.println("username=" + username + ", password=" + password);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>The executed SQL command is:\n\nSELECT * FROM user WHERE username='" + username + "' and password='" + password + "';</body></html>");
        out.print("<script>alert('Submitted successfully');</script>");
        out.close();

        // Connect to the database and execute the query
        String sql = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "';";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("sql=" + sql);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // operations based on the results returned
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        super.destroy();
    }

}
