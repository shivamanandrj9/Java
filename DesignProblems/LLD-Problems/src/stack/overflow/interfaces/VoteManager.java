package stack.overflow.interfaces;

public interface VoteManager{
    public void vote(String commentId, VoteAction action, String userId);
}