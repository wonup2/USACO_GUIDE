import java.sql.SQLException;

public class Test2 {

	private static void availableSeats() throws SQLException{
		throw new SQLException();
	}
	public static void main(String[] args) {

		try {
			availableSeats();
		} catch(SQLException e) {
			System.out.println("SEATS NOT AVAILABLE");
		} catch(Exception e) {
			System.out.println("GOTCHA!");
		}
	}

}
