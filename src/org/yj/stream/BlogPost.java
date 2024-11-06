package org.yj.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}

class Tuple {
    BlogPostType type;
    String author;

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Tuple(BlogPostType type, String author) {
        this.type = type;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "type=" + type +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.author.length()+this.type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Tuple tuple = (Tuple) obj;
        if (tuple.getAuthor().equals(this.author) && tuple.getType() == this.type) {
            return true;
        }
        return false;
    }
}

public class BlogPost {
    private String title;
    private String author;
    private BlogPostType type;
    private int likes;
    private Tuple tuple;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
        this.tuple =new Tuple(type,author);
    }

    public Tuple getTuple() {
        return tuple;
    }

    public void setTuple(Tuple tuple) {
        this.tuple = tuple;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", likes=" + likes +
                '}';
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");

  /*      System.out.println(list.stream().mapToInt(item -> item.length()).max().getAsInt());
        System.out.println(list.stream().max(Comparator.comparingInt(str -> str.length())).get());
        System.out.println(list.stream().map(item -> item.length()).max(Comparator.comparingInt(len -> len)).get());

        System.out.println(list.stream().mapToInt(item->item.length()).sum());

        System.out.println(list.stream().sorted(Comparator.comparing(item -> item.length())).collect(Collectors.toList()));

        System.out.println(list.stream().collect(Collectors.toMap(item -> item, item -> item.length())));*/

        BlogPost p1 = new BlogPost("title1", "author1", BlogPostType.NEWS, 1);
        BlogPost p2 = new BlogPost("title2", "author2", BlogPostType.NEWS, 2);
        BlogPost p3 = new BlogPost("title3", "author3", BlogPostType.NEWS, 3);
        BlogPost p4 = new BlogPost("title7", "author1", BlogPostType.NEWS, 3);
        BlogPost p11 = new BlogPost("title4", "author1", BlogPostType.GUIDE, 1);
        BlogPost p22 = new BlogPost("title5", "author2", BlogPostType.GUIDE, 2);
        BlogPost p33 = new BlogPost("title6", "author3", BlogPostType.GUIDE, 3);

        List<BlogPost> posts = List.of(p1, p2, p3, p4, p11, p22, p33);
        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getType(), Collectors.maxBy(Comparator.comparingInt(item->item.likes)))));
        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getType(), Collectors.groupingBy(item->item.getAuthor(),Collectors.mapping(item->item.getTitle(),Collectors.toList())))));
        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getType(), Collectors.counting())));
        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getType(), Collectors.mapping(item->item.title,Collectors.toList()))));
        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getType(), Collectors.groupingBy(item -> item.getAuthor(), Collectors.mapping(item -> item.getTitle(), Collectors.toSet())))));


        System.out.println(posts.stream().collect(Collectors.groupingBy(BlogPost::getTuple, Collectors.counting())));
//        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getType(), Collectors.mapping(item->item.getAuthor(),Collectors.toList()))));
//        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getAuthor(),Collectors.counting())));
//        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getAuthor(), Collectors.mapping(item -> item.getTitle(), Collectors.toSet()))));
//        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.getAuthor(), Collectors.groupingBy(element -> element.getType(),Collectors.mapping(element->element.getTitle(),Collectors.toSet())))));
        // System.out.println(posts.stream().collect(Collectors.toMap(item -> item.getTitle(), Function.identity())));

/*        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.title, Collectors.groupingBy(item -> item.type))));
        System.out.println(posts.stream().collect(Collectors.groupingBy(item -> item.title)));


        Map<Tuple, List<BlogPost>> map = posts.stream().collect(Collectors.groupingBy(item -> new Tuple(item.type, item.author)));
        System.out.println(map);*/
    }
}
