package bot.export;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import bot.entities.Acesso;

public class Export {

	private static final String PATH_LOGIN_DATA = "C:/Bot_Files/acessos.csv";

	public void exportToCsv(List<Acesso> acessos) {

		try {
			Writer writer = Files.newBufferedWriter(Paths.get(PATH_LOGIN_DATA));
			StatefulBeanToCsv<Acesso> beanToCsv = new StatefulBeanToCsvBuilder<Acesso>(writer).build();

			beanToCsv.setOrderedResults(true);
			beanToCsv.write(acessos);
			
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
