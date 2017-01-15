
            <ul>
                <#list topics as topic>

                  <li>
                    <div data-role="collapsible">
                        <h1>${topic_index + 1}. ${topic.name} </h1>
                        <ul>
                            <#list topic.posts as post>
                                <li>
                                    <h3>${post_index + 1}. ${post.subject}(von ${post.author})</h3>
                                    <p>${post.text}</p>
                                    <ul>
                                        <#list post.comments as comment>
                                            <li>
                                                <h4>${comment_index + 1}.  ${comment.subject}(von ${comment.author})</h4>
                                                <p>${comment.text}</p>
                                             </li>
                                        </#list>
                                    </ul>
                                 </li>
                            </#list>
                        </ul>
                    </div>
                  </li>
                </#list>
              </ul>
