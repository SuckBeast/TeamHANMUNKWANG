package Model;

public class Review {
	private String id;
	private int star;
	private String writeView;
	public Review(String id, int star, String writeView) {
		super();
		this.id = id;
		this.star = star;
		this.writeView = writeView;
	}
	public String getId() {
		return id;
	}
	public int getStar() {
		return star;
	}
	public String getWriteView() {
		return writeView;
	}
}
