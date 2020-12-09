package com.zzar.pomreader.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.zzar.pomreader.model.PlugInsDTO;
import com.zzar.pomreader.model.ProjectDTO;

@Component
public class PomReadUtil {

	public PlugInsDTO getPomReport() {
		ProjectDTO project = null;
		try {

			File file = readPomFile();
			/*
			 * JAXBContext jaxbContext = JAXBContext.newInstance(StudentDTO.class);
			 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); student =
			 * (StudentDTO) jaxbUnmarshaller.unmarshal(file);
			 * 
			 * System.out.println(student.getName() + " " + student.getEmailAddress());
			 * return student.getName() + " " + student.getEmailAddress();
			 */
			
			JAXBContext jaxbContext = JAXBContext.newInstance(ProjectDTO.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			project = (ProjectDTO) jaxbUnmarshaller.unmarshal(file);

			System.out.println(project.getBuild().getPlugins().getPluginList().get(0).getArtifactId() 
					+ " " + project.getBuild().getPlugins().getPluginList().get(0).getGroupId()
					+ " " + project.getBuild().getPlugins().getPluginList().get(0).getVersion());
			return project.getBuild().getPlugins();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	private File readPomFile() {
		File file = null;
		try {
			//file = ResourceUtils.getFile("classpath:input/student.xml");
			file = ResourceUtils.getFile("classpath:input/pom.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
