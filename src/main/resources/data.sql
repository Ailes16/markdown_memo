insert into memos (memo_name,content,group_id) values ('test1','# markdownアプリの作成
- リスト1
- リスト2
- リスト3  
[リンク](https://google.com)',1);
insert into memos (memo_name,content,group_id) values ('test2','# table
table|#|#
-|-|-
practice1|practice2|practice3',2);
insert into memos (memo_name,content,group_id) values ('test3','# code test
```java
public class Test{
    public static void main(String[] args){
        System.out.println("Hello world!!");
    }
}
```

```html
<h1>highlight test</h1>
<p>texttexttext</p>
```

```css
div {
    background-color: #fff;
    color: #000;
}
```
',1);
insert into groups (group_name) values ('testGroup');
insert into groups (group_name) values ('testGroup2');