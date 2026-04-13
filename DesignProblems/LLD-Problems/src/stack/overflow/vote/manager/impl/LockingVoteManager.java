package stack.overflow.vote.manager.impl;

public class LockingVoteManager implements VoteManger{

    private final ConcurrentHashMap<VoteKey, ReentrantLock> voteLock=new ConcurrentHashMap<>();
    private final VoteDao voteDao=new VoteDao();

    public void vote(String commentId, VoteAction action, String userId){

        VoteKey currVoteKey=new VoteKey(commentId, userId);
        ReentrantLock currLock=voteLock.computeIfAbsent(currVoteKey, k -> {
            return new ReentrantLock();
        });

        currLock.lock();

        try{
            Vote currVote=new Vote(userId, commentId, action);
            if(!voteDao.isPresent(currVote)){
                voteDao.save(currVote);
            }
        }
        finally{
            currLock.unlock();
            
        }

    }

    public static class VoteKey{
        String commentId;
        String userId;

        @Override
        public boolean equals(Object o){
            if(this==o) return true;
            if(!(o instanceof VoteKey)) return false;
            VoteKey curr=(VoteKey) o;
            return (Objects.equals(curr.commentId, this.commentId) && Objects.equals(curr.userId, this.userId));
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.commentId, this.userId);
        }
    }
}