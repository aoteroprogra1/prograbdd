
package bddprograma;

import java.sql.*;
import java.util.Scanner;

public class BDDprograma {

    public static void main(String[] args) {
        boolean salir=true;
        
        String usuario="root";
        String clave="";
        Statement stmt=null;
        ResultSet rs=null;
        Scanner in=new Scanner(System.in);
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            String url="jdbc:mysql://localhost:3306/prueba";
            Connection con=DriverManager.getConnection(url,usuario,clave);
            stmt=con.createStatement();
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        do{
          System.out.println("1.-CREAR NUEVA MASCOTA");
            System.out.println("2.-BUSCAR MASCOTAS");
            System.out.println("3.-ELIMINAR MASCOTA");
            System.out.println("4.-ACTUALIZAR DATOS DE MASCOTA");
            System.out.println("5.-MOSTRAR TODAS LAS MASCOTAS");
            System.out.println("6.-SALIR");
            int opt=Integer.parseInt(in.nextLine());
       
            switch (opt){
               
                case 1:{
                    try{
                    System.out.println("Ingrese nombre de la mascota");
                    String a=in.nextLine();
                    System.out.println("Ingrese edad de la mascota");
                    String b=in.nextLine();
                    System.out.println("Ingrese peso de la mascota");
                    String c=in.nextLine();
                    stmt.executeUpdate("insert into mascota(nombre,edad,peso) values('"+a+"','"+b+"','"+c+"');");
                    }catch(SQLException ex){
                    System.out.println("ERROR:"+ex.toString());
                    }
                    break;
                }
                //LELELELELEL
                case 2:{
                    System.out.println("Ingrese nombre a buscar:");
                    String nombre=in.nextLine();
                    try{
                    rs=stmt.executeQuery("select * from mascota where nombre='"+nombre+"';");
                    while(rs.next()){
                    System.out.println("ID:"+rs.getString("mascota_id"));
                    System.out.println("NOMBRE:"+rs.getString("nombre"));
                    System.out.println("EDAD:"+rs.getString("edad"));
                    System.out.println("PESO:"+rs.getString("peso"));
                    }
                }catch(SQLException e){
                    System.out.println("Error SQL: "+e.toString());
                }
                    break;
                }    
                case 3:{
                    System.out.println("Ingrese nombre de mascota a eliminar:");
                    String delete=in.nextLine();
                    try{
                    stmt.executeUpdate("delete from mascota where nombre='"+delete+"';");
                    }catch(SQLException ex){
                        System.out.println("Error SQL: "+ex.toString());
                    }
                    break;
                }
                case 4:{
                        System.out.println("Ingrese nombre de mascota a actualizar:");
                        String dele=in.nextLine();
                        System.out.println("Ingrese columna de mascota a actualizar:");
                        String del=in.nextLine();
                        System.out.println("Ingrese valor del parametro:");
                        String deel=in.nextLine();
                    try{
                        
                        stmt.executeUpdate("update mascota set "+del+"='"+deel+"' where nombre='"+del+"';");
                    }
                    catch(SQLException as){
                        System.out.println("Error SQL: "+as.toString());
                    }
                    break;
                }
                case 5:{
                    try{
                        rs=stmt.executeQuery("select * from mascota");
                while(rs.next()){
                    System.out.println("ID:"+rs.getString("mascota_id"));
                    System.out.println("NOMBRE:"+rs.getString("nombre"));
                    System.out.println("EDAD:"+rs.getString("edad"));
                    System.out.println("PESO:"+rs.getString("peso"));
            }
                    }catch(SQLException ar){
                        System.out.println("Error SQL: "+ar.toString());
                       
                    }
                    break;
                }
                case 6:{
                    salir=false;
                    break;
                }
                
        }
        }    
           
        while (salir==true);{
            System.out.println("Creado por: Andres Otero");
    }   
}
}
    
    

