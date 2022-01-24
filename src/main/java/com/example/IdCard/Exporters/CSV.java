package com.example.IdCard.Exporters;

import com.example.IdCard.model.OneCard;
import com.example.IdCard.services.IdCardServiceImpl;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CSV {
    public void getFile(HttpServletResponse response, List<OneCard> oneCardList) throws IOException {
        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=yourIdCard.csv";
        response.setHeader(headerKey, headerValue);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Id", "Name", "Surname", "Phone", "Email", "Birthday"};
        String[] nameMapping = {"id", "name", "surname", "phone", "email", "birthday"};

        csvWriter.writeHeader(csvHeader);

        for (OneCard oneCard : oneCardList) {
            csvWriter.write(oneCard, nameMapping);
        }

        csvWriter.close();
    }
}
