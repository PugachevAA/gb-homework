import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

@WebServlet (name = "ViewProducts" , urlPatterns = {"/products"})
public class ViewProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rnd = new Random();
        ArrayList<Product> productList = new ArrayList<>();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        for (int i = 0; i < 10; i++) {
            productList.add(new Product(i, "Product" + i, BigDecimal.valueOf(rnd.nextInt(100000)/10d)));
        }

        for (int i = 0; i < productList.size(); i++) {
            resp.getWriter().println("<div>" + productList.get(i).getInfo() + "</div>");
        }
    }
}
