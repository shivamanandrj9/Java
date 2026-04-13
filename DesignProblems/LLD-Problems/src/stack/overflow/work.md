# Problem Statement

Design Stack Overflow

# Requirements

1. User can come and write some post.
2. There can be categories of post queries (By categories, we mean tags only).
3. Users can write comments against a post.
4. Comments can be upvoted and downvoted.
5. Comments can have subcomments like replies.
6. [Peeked] User can only vote once per comment.
7. [Peeked] The author of the post can select a comment as answer.
8. [Peeked] There is some reputation point that is associated to a user.
    upvote -> +1 rep
    downvote -> -1 rep
    accepted -> +5 rep
9. [Peeked] A question can have multiple tags associated to it.
10. [Peeked] A question can be searched via keyword or tags.



# Entities

1. User 
    {
        userId: String
        nickname: String
        email: String
        repScore: integer
    }

2. Post
    {
        postId: String
        post: String
        userId: FK
    }

3. PostTagMapping
    {
        postId: FK
        tag: Tag
    }

4. Comment
    {
        userId : FK
        commentId: String
        comment: String
        postId: FK
        isSelected: boolean
        parentCommentId: FK
    }

5. Vote
    {
        userId: FK
        commentId: FK
        action: VoteAction
    }


# Enums

1. Tag {Java, C++}

2. VoteAction {UPVOTE, DOWNVOTE}


# Controllers



# Services

1. PostService

String createPost(PostCreationRequestDTO postCreationRequest, String userId) {...}

String searchPost(PostSearchFilter filter) {...}

String getPost(String postId) {...}


2. CommentService

String addPostComment(String comment, String userId, String postId) {...}

String addCommentReply(String comment, String userId, String parentCommentId) {...}

void selectComment(String commentId, String userId, String postId) {...}


3. VoteService

void voteComment(String commentId, VoteAction action, String userId) {...}




# Models

PostCreationRequestDTO
{
    String post;
    List<Tag> tags;
}

PostSearchFilter
{
    String keyword;
    List<Tag> tag;
}


# DAOs

UserDao{
    list<User> users;


}

PostDao{
    List<Post> posts;

}

CommentDao{
    List<Comment> comments;
}

VoteDao{
    List<Vote> votes;
}

PostTagMappingDao{
    List<PostTagMapping> postTagMappings;
}


# Interfaces