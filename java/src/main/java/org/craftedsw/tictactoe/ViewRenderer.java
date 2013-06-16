package org.craftedsw.tictactoe;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import static de.neuland.jade4j.Jade4J.getTemplate;

public class ViewRenderer {

    private String templateFolder;

    public ViewRenderer() {
        findTemplateFolder();
    }

    public String render(String templateName, Map<String, Object> model) {
        JadeTemplate template;
        try {
            template = getTemplate(templateFolder + templateName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return Jade4J.render(template, model);
    }

    private void findTemplateFolder() {
        File currentDirectory = new File(".");
        String[] jadeFiles = new String[] {"jade"};
        boolean recursive = true;
        Collection<File> templates = FileUtils.listFiles(currentDirectory, jadeFiles, recursive);

        File indexPage = (File) templates.toArray()[0];
        templateFolder = indexPage.getParent() + "/";
    }

}
