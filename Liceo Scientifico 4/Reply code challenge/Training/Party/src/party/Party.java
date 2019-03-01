package party;

import java.util.ArrayList;

public class Party {

	
	private ArrayList<Friend> friends;
	
	
	
	

	public Party(ArrayList<Friend> friends) {
		super();
		this.friends = friends;
	}





	public int calcMaxBeauty() {
		int res = 0;
		
		for(Friend f: friends) {
			if(f.getFriendshipRating() >= 0) {
				res += f.getFriendshipRating();
			}
		}
		
		return res;
	}





	public ArrayList<Friend> getFriends() {
		return friends;
	}

	
	
}
