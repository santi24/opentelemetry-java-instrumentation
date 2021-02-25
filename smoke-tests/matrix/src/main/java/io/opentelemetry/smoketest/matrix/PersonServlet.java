package io.opentelemetry.smoketest.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonServlet extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader bufferedReader = req.getReader();

    try {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line).append('\n');
      }
    } finally {
      bufferedReader.close();
    }
    resp.setStatus(HttpServletResponse.SC_OK);
    resp.getWriter().write(stringBuilder.toString());
    resp.getWriter().flush();
  }
}
