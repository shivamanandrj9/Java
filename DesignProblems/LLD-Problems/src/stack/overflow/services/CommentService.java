public class CommentService{

    private final CommentDao commentDao=new CommentDao();

    public int addPostComment(String comment, String userId, String postId){
        Comment comment=new Comment(userId, comment, postId, false, null);
        return commentDao.save(comment);
    }

    public int addCommentReply(String comment, String userId, String parentCommentId){

        Comment comment=commentDao.get(parentCommentId);
        Comment comment = new Comment(userId, comment, comment.postId, false, parendCommentId);
    }

}