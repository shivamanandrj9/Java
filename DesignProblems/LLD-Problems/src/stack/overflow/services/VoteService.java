package stack.overflow.services;

public class VoteService{

    private final VoteManager voteManger=new LockingVoteManger();

    void voteComment(String commentId, VoteAction action, String userId) {
        voteManger.vote(commentId, action, userId);
    }
}