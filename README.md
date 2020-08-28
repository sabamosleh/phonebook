To run application using docker:

First pull a mysql image. to create a container:

`sudo docker run -d --name=phone_book_db --env="MYSQL_ROOT_PASSWORD=0" --env="MYSQL_PASSWORD=0" --env="MYSQL_USERNAME=root" --env="MYSQL_DATABASE=phone_book" mysql:5.7.25`

Replace --env values with you're mysql credentials.
check phone_book_db details using:
`sudo docker inspect phone_book_db`

Replace current phone_book_db ip in application.properties file in phonebook project(resources).

Build you're image of phonebook application using:
`sudo docker run --name=phone_book_app phonebook:0.0.2`

To run container of phonebook:0.0.2 image linked to phone_book_db container:
`sudo docker run -t --link phone_book_db:mysql -p 10222:10222 phonebook:0.0.2`

If every thing went well the app should response on current ip (you can find it using `sudo docker inspect`) 
and 5028 port.

URLs:

To add a contact :` http://ip:port/contacts`
To search a contact:` http://ip:port/search`

You can test the api using Postman and samples in project.



-------------------------------------
Solution for problem in part2:

We can take advantage of multi threading using  CompletableFuture so saving contact
and storing repositories will execute separately and possible delays would not effect saving
contacts.

in ContactController each save request will execute  `CompletableFuture<List<GithubRepo>> repositories=githubRepositoryService.getContactRepositories(contact);`
so saving repositories will be another threads responsibility.

Also we can config an executor to determine Thread Counts to handle `getContactRepositories(contact)` in configuration class:
`
  @Bean (name = "taskExecutor")
    public Executor taskExecutor() {
        
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(2);

        executor.setMaxPoolSize(2);//Max Threads in the  pool

        executor.setQueueCapacity(100);//Max Queue Size 

        executor.setThreadNamePrefix("TestThread-");

        executor.initialize();

        return executor;

    }`
