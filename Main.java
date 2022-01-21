package application;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		//double radius;
		try {
			
			double height = 1000;
			double width = 1000;
			StackPane root = new StackPane();
			Canvas canvas = new Canvas(height,width);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			MyPoint center = new MyPoint(height/2, width/2);
			
			/*
			 * 	File file = new File("C:\\Users\\Resik\\Downloads\\emma.txt");
			Scanner scan = new Scanner(file);
			 * while(scan.hasNext())
			{
				line.add(scan.next());
			}
			scan.close();
			
			for (int i = 0; i < line.size();++i)
			{
				String temp = line.get(i); //get string of that line
				String filtered = temp.replaceAll("[^a-zA-Z]", ""); //remove everything that is NOT letters
				String lowercase = filtered.toLowerCase();
				line.set(i, lowercase);
			}
			*/
			Scanner scanint = new Scanner(System.in);
			System.out.println("How many events should I calculate?: ");
			int n = scanint.nextInt();
			scanint.close();
			//Create MyPieChart
			double smallest = Math.min(height, width);
			double radius = 200%smallest;
			
			MyPieChart pie = new MyPieChart(radius, center, MyColor.PURPLE, gc, n);
			
			{
				Connection connection = null;
				PreparedStatement prepstate = null;
				ResultSet result = null;
				String grade = "";
				int counts = 0;
				//Sums the grades grouped by grade in the class 22100 F.
				try {
					connection = Connect.getConnection();
					prepstate = connection.prepareStatement("SELECT grade, COUNT(grade) AS counts FROM classes WHERE courseID = ? GROUP BY grade");
					prepstate.setString(1, "22100 F");
					result = prepstate.executeQuery();
					
					while(result.next())
					{
						grade = result.getString("grade");
						System.out.print(grade);
						counts = result.getInt(2);
						System.out.println(" " + counts);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				Connect.Close(connection, prepstate);
			}
			// Insert data into the piechart.
			{
				Connection connection = null;
				PreparedStatement prepstate = null;
				ResultSet result = null;
				String grade = "";
				try {
					connection = Connect.getConnection();
					prepstate = connection.prepareStatement("SELECT * from classes");
					result = prepstate.executeQuery();
					
					while(result.next())
					{
						grade = result.getString("grade");
						pie.insertData(grade.charAt(0));
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				Connect.Close(connection, prepstate);
			}
			
			
				//GUI to calculate n most frequent letters.
			
			
			pie.draw();
			root.getChildren().add(canvas);
			Scene scene = new Scene(root,1000,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
		Students stud1 = new Students("Johnny", "Basurto", 321, "jbasurt000@citmail.cuny.edu", "M");
		Students stud2 = new Students("Tico", "Vilanueva", 1234, "tico@email.com", "M");
		Students stud3 = new Students("Jazmin", "Vilanueva", 1245, "jazming@email.com", "F");
		Students stud4 = new Students("An", "Bryan", 123, "an@email.com", "F");
		Students stud5 = new Students("Estef", "Mor", 4321, "estef@gmail.com", "F");
		Students stud6 = new Students("Ant", "Wat", 54321, "Ant@email.com", "M");
		Students stud7 = new Students("Hash", "Brown", 12456, "Hash@email.com", "M");
		Students stud8 = new Students("Umer", "Kh", 654321,"Umer@email.com","M");
		Students stud9 = new Students("Ray","Di", 1234567, "Ray@email.com","F");
		
		Classes class1 = new Classes("22100 F", stud2.getEmpID(), 34143, 2021, "Spring", null);
		Classes class2 = new Classes("22100 F", stud3.getEmpID(), 32118, 2021, "Spring", null);
		Classes class3 = new Classes("22100 F", stud4.getEmpID(), 32124, 2021, "Spring", null);
		Classes class4 = new Classes("22100 F", stud5.getEmpID(), 32129, 2021, "Spring", null);
		Classes class5 = new Classes("22100 F", stud6.getEmpID(), 32130, 2021, "Spring", null);
		Classes class6 = new Classes("22100 F", stud7.getEmpID(), 32131, 2021, "Spring", null); //REPEAT A LOT OF THESE FOR JAVA CLASS
		Classes class7 = new Classes("22100 F", stud8.getEmpID(), 32134, 2021, "Spring", null);
		
		Courses cor1 = new Courses("10000 PP", "Introduction to Programming & Computer Science", "Computer Science");
		Courses cor2 = new Courses("10200 CC1", "Introduction to Computing", "Computer Science");
		Courses cor3 = new Courses("10400 EF1", "Discrete Mathematical Structures", "Computer Science");
		Courses cor4 = new Courses("21200 BC", "Data Structures", "Computer Science");
		Courses cor5 = new Courses("22000 C", "Algorithms", "Computer Science");
		Courses cor6 = new Courses("22100 F", "Software Design Laboratory","Computer Science"); //REPEAT A LOT OF THESE FOR JAVA CLASS
		Courses cor7 = new Courses("32200 P", "Software Engineering", "Computer Science");
		
		Cours_Methods.createTable();
		Class_Methods.createTable();
		Stu_Methods.createTable();
		
		Stu_Methods.insert(stud1);
		Stu_Methods.insert(stud2);
		Stu_Methods.insert(stud3);
		Stu_Methods.insert(stud4);
		Stu_Methods.insert(stud5);
		Stu_Methods.insert(stud6);
		Stu_Methods.insert(stud7);
		Stu_Methods.insert(stud8);
		Stu_Methods.insert(stud9);
		
		Class_Methods.insert(class1);
		Class_Methods.insert(class2);
		Class_Methods.insert(class3);
		Class_Methods.insert(class4);
		Class_Methods.insert(class5);
		Class_Methods.insert(class6);
		Class_Methods.insert(class7);
		
		
		Class_Methods.update(class1, stud2, "A");
		Class_Methods.update(class2, stud3, "B");
		Class_Methods.update(class3, stud4, "A");
		Class_Methods.update(class4, stud5, "C");
		Class_Methods.update(class5, stud6, "C");
		Class_Methods.update(class6, stud7, "B");
		Class_Methods.update(class7, stud8, "A");

		
		
		Cours_Methods.insert(cor1);
		Cours_Methods.insert(cor2);
		Cours_Methods.insert(cor3);
		Cours_Methods.insert(cor4);
		Cours_Methods.insert(cor5);
		Cours_Methods.insert(cor6);
		Cours_Methods.insert(cor7);
		
		launch(args);
	}
}
