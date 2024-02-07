import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Part1 {
    // PROCESSING THE STRING
    // get all atributes from entity
    public static String getAttribute(String entity){
    String regex = "\\(([^)]+)\\)"; 
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(entity);
    if (matcher.find()) {
        return matcher.group(1);
    }
    return "";
    }

    // set all atributes from entity
    public static String setAttribute(String entity,  String attributes){
        
        String regex = "\\(([^)]+)\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entity);

        // replace all attributes
        if (matcher.find()) {
            String oldContent = matcher.group(1);
            String modifiedString = entity.replace(oldContent,  attributes);
            return modifiedString;
        }

        
        return entity;
    }
    

    public static void main(String[] args) {
        HashMap<Integer, String> entityMap = new HashMap<>();

        entityMap.put(0, "Apartment(floor_number) ");
        entityMap.put(1, "House(*House_id, province_city, ward_district, number, area)");
        entityMap.put(2, "Customer(*customer_id, full_name, work_place, address, phone_number)");
        entityMap.put(3, "Contract(*contract_id, sign_date, contract_available)");
        entityMap.put(4, "Branch(*branch_id, branch_name)");
        entityMap.put(5, "Vote(vote_date, score, assesst)");
        entityMap.put(6, "Employee(employee_id, full_name, position, address, phone_number)");

        LinkedList<Edge> edges = new LinkedList<Edge>();
        try {
            
            File file = new File(".\\input1.txt");
            Scanner file_scaned = new Scanner(file);
            
            while (file_scaned.hasNextLine()) {
                String data[] = file_scaned.nextLine().split("   ");
                Edge edge = new Edge(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2]);
                edges.add(edge);
            }
            for(Edge edge : edges) {
                    String e_1,  attributes_e1;
                    String e_n,  attributes_en;
                    String newEntity;
                    switch (edge.qh) {
                    case "1-n":
                        e_1 = entityMap.get(edge.u); attributes_e1 = getAttribute(e_1);
                        e_n = entityMap.get(edge.v); attributes_en = getAttribute(e_n);

                        for(String i : attributes_e1.split(", ")){
                            if (i.charAt(0) == '*'){
                                attributes_en += ", " + i;
                                break;
                            }
                        }
                        newEntity = setAttribute(e_n,  attributes_en);
                        entityMap.put(edge.v,  newEntity);
                        break;
                    case "n-1":
                        e_1 = entityMap.get(edge.v); attributes_e1 = getAttribute(e_1);
                        e_n = entityMap.get(edge.u); attributes_en = getAttribute(e_n);

                        for(String i : attributes_e1.split(", ")){
                            if (i.charAt(0) == '*'){
                                attributes_en += ", " + "'"+ i;
                                break;
                            }
                        }
                        newEntity = setAttribute(e_n,  attributes_en);
                        entityMap.put(edge.v,  newEntity);
                        break;
                    case "1-1":
                        String e1_1 = entityMap.get(edge.u),  attributes_e1_1 = getAttribute(e1_1);
                        String e2_1 = entityMap.get(edge.v), attributes_e2_1 = getAttribute(e2_1);
                       
                        String newEntity_case_11;
                        if(edge.u < edge.v){     // v > u => primary key of u is foreign key of v, 
                            for(String i : attributes_e1_1.split(", ")){
                                if (i.charAt(0) == '*'){
                                    attributes_e2_1 += ", " + i;
                                    break;
                                }
                            }
                            newEntity_case_11 = setAttribute(e2_1,  attributes_e2_1);
                            entityMap.put(edge.v,  newEntity_case_11);
                        }else{ // u > v => primary key of v is foreign key of u, 
                            for(String i : attributes_e2_1.split(", ")){
                                if (i.charAt(0) == '*'){
                                    attributes_e1_1 += ", " + i;
                                    break;
                                }
                            }
                        newEntity_case_11 = setAttribute(e1_1,  attributes_e1_1);
                        entityMap.put(edge.v,  newEntity_case_11);
                        }
                        break;
                    case "cha-con":
                        String newEntity_of_child;
                        if(edge.u < edge.v){     // v > u => v is parent of u, 
                            String parent = entityMap.get(edge.v),  attributes_parent = getAttribute(parent);
                            String child  = entityMap.get(edge.u),  attributes_child = getAttribute(child);
                            attributes_parent += ", " + attributes_child;
                            newEntity_of_child = setAttribute(child,  attributes_parent);
                            entityMap.put(edge.u,  newEntity_of_child);
                        }else{ // u > v => u is parent of v, 
                            String parent = entityMap.get(edge.u),  attributes_parent = getAttribute(parent);
                            String child  = entityMap.get(edge.v),  attributes_child = getAttribute(child);
                            attributes_parent += ", " + attributes_child;
                            newEntity_of_child = setAttribute(child,  attributes_parent);
                            entityMap.put(edge.u,  newEntity_of_child);
                        }
                        break;
                    default: // n-n
                        String e1_n_n = entityMap.get(edge.u),  attributes_e1_n_n = getAttribute(e1_n_n);
                        String e2_n_n = entityMap.get(edge.v),  attributes_e2_n_n = getAttribute(e2_n_n);
                        // get name of the entity
                        String table_name_1 = e1_n_n.substring(0,  e1_n_n.indexOf('('));
                        String table_name_2 = e2_n_n.substring(0,  e2_n_n.indexOf('('));
                        // create new table
                        String new_table = table_name_1 + "_" + table_name_2;
                        // two primary keys
                        String key1 = "",  key2 = "";
                        for(String i : attributes_e1_n_n.split(", ")){
                            if (i.charAt(0) == '*'){
                                key1 = i;
                                break;
                            }
                        }
                        for(String i : attributes_e2_n_n.split(", ")){
                            if (i.charAt(0) == '*'){
                                key2 = i;
                                break;
                            }
                        }
                        entityMap.put(entityMap.size(),  new_table + "(" + key1 + ", " + key2 + ")");                          
                        break;
                   }
            }
            
            FileWriter fileWriter = new FileWriter(".\\Output.txt");
            for (String value : entityMap.values()) {
                fileWriter.write(value + "\n");
            }
            fileWriter.close();
            file_scaned.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}