package dsa.linkedlist;

import java.util.Scanner;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

public class SocialMediaFriends {

    private UserNode head;

    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    private UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId, int friendId) {
        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;
        System.out.println("Friend added");
    }

    public void removeFriend(int userId, int friendId) {
        UserNode user = findUser(userId);
        if (user == null || user.friends == null) {
            System.out.println("Friend not found");
            return;
        }
        if (user.friends.friendId == friendId) {
            user.friends = user.friends.next;
            System.out.println("Friend removed");
            return;
        }
        FriendNode temp = user.friends;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Friend not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Friend removed");
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friends;
        if (temp == null) {
            System.out.println("No friends");
            return;
        }
        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }

    public void countFriends(int userId) {
        UserNode user = findUser(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        int count = 0;
        FriendNode temp = user.friends;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total friends: " + count);
    }

    public void mutualFriends(int user1, int user2) {
        UserNode u1 = findUser(user1);
        UserNode u2 = findUser(user2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Mutual Friends:");
        FriendNode f1 = u1.friends;
        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Friend ID: " + f1.friendId);
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.println("No mutual friends");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SocialMediaFriends sm = new SocialMediaFriends();

        while (true) {
            System.out.println("\n1 Add User");
            System.out.println("2 Add Friend");
            System.out.println("3 Remove Friend");
            System.out.println("4 Display Friends");
            System.out.println("5 Count Friends");
            System.out.println("6 Mutual Friends");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            int uid, fid, uid2;
            String name;
            int age;

            switch (choice) {
                case 1:
                    System.out.print("User ID: ");
                    uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    sm.addUser(uid, name, age);
                    break;

                case 2:
                    System.out.print("User ID: ");
                    uid = sc.nextInt();
                    System.out.print("Friend ID: ");
                    fid = sc.nextInt();
                    sm.addFriend(uid, fid);
                    break;

                case 3:
                    System.out.print("User ID: ");
                    uid = sc.nextInt();
                    System.out.print("Friend ID: ");
                    fid = sc.nextInt();
                    sm.removeFriend(uid, fid);
                    break;

                case 4:
                    System.out.print("User ID: ");
                    uid = sc.nextInt();
                    sm.displayFriends(uid);
                    break;

                case 5:
                    System.out.print("User ID: ");
                    uid = sc.nextInt();
                    sm.countFriends(uid);
                    break;

                case 6:
                    System.out.print("First User ID: ");
                    uid = sc.nextInt();
                    System.out.print("Second User ID: ");
                    uid2 = sc.nextInt();
                    sm.mutualFriends(uid, uid2);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
