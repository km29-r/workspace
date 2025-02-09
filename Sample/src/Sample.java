import pack.Student;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Student s1 = new Student();
		s1.setName("菅原");
		s1.setScore(80);
		Student s2 = new Student();
		s2.setName("桜井");
		s2.setScore(-80);

		System.out.println(s1.getName() + "さん" + s1.getScore() + "点");
		System.out.println(s2.getName() + "さん" + s2.getScore() + "点");

	}

}
