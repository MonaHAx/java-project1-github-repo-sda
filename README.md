---


---

<h1 id="online-sport-management-system">Online Sport Management System</h1>
<p>The Online Sport Management System is a platform that aims to provide users with a comprehensive solution for managing and organizing sports events and activities. It offers a range of services to both managers and players, facilitating  efficient event planning, registration, and communication.</p>
<h2 id="class-diagram">Class Diagram</h2>
<p><a href="https://drive.google.com/file/d/1IRQ3s7EYKfNWa0bha4ttz6eIW_Kc9hrb/view?usp=sharing">UML diagram</a></p>
<h2 id="key-features">Key Features</h2>
<ul>
<li>
<p>Event Management:<br>
Manager can create and manage sports events by providing essential details such as event name, date, time, location, and sport type.</p>
</li>
<li>
<p>Player Registration:<br>
Players can easily register for sports events through the online platform. They can provide their personal information, select the events they wish to participate in.</p>
</li>
<li>
<p>Event Promotion:<br>
The system allows managers to promote their events by providing event descriptions and other relevant information. Players can browse and search for upcoming events.</p>
</li>
</ul>
<h2 id="controllers-and-routes-structure">Controllers and Routes structure</h2>
<p>The Online Sport Management System typically involves different controllers , each with specific functionalities and permissions. Common controllers may include:</p>
<ol>
<li>
<p><strong>Manager</strong>: Users with manager roles can create, manage, and oversee sports events. They have access to administrative features, such as event creation, participant management, and event analytics.</p>
<blockquote>
<p>Routes structure:<br>
1-Get manager by ID<br>
2- Post new manager<br>
3- Delete manager<br>
4-Patch manager name</p>
</blockquote>
</li>
<li>
<p><strong>Player</strong>: Users with Player roles can browse and register for sports events. They can view event details, submit registration forms.</p>
</li>
</ol>
<blockquote>
<p>Routes structure:<br>
1-Get player by ID<br>
2-Get player by sport specification<br>
3- Post new player<br>
4- Delete player<br>
5-Put player information</p>
</blockquote>
<ol start="3">
<li><strong>Event</strong>: Events controller contains all information details that related to specific event. Like, event name, time, date, and platform.</li>
</ol>
<blockquote>
<p>Routes structure:<br>
1-Get event by ID<br>
2-Get event by platform<br>
3- Post new event<br>
4- Delete event<br>
5-Put player information</p>
</blockquote>
<h2 id="installation">Installation</h2>
<p>This project requires three programs to use:<br>
1-spring initializr <a href="https://start.spring.io/">spring initializr</a> to generates <em>spring</em> boot project with just what you need to start quickly!<br>
2- IntelliJ IDEA Ultimate <a href="https://www.jetbrains.com/idea/download/?section=windows">IntelliJ</a> to run.<br>
3- Dbeaver <a href="https://dbeaver.com/download/">DBeaver</a> to store the database.<br>
4-Postman <a href="https://www.postman.com/downloads/">Postman</a> to build and use APIs.</p>
<p>After installing all three programs, you can launch IntelliJ IDEA Ultimate to start developing your project, use DBeaver to manage your database, and utilize Postman to build and interact with APIs.</p>
<h2 id="future-work">Future Work</h2>
<p>potential future enhancements and features for the Online Sport Management System:</p>
<ol>
<li>
<p><strong>Player Feedback</strong>: Integrate a feedback system to gather player feedback on events, enabling manager to gather insights and make improvements based on user input.</p>
</li>
<li>
<p><strong>Event Photo Galleries</strong>: Include a photo gallery feature where managers and players can upload and share event photos, capturing and preserving memorable moments from sports events.</p>
</li>
<li>
<p><strong>Event Ratings</strong>: Introduce a simple rating system where players can provide feedback and rate events based on their overall experience, facilities, organization, and other relevant factors.</p>
</li>
</ol>
<h2 id="resources">Resources</h2>
<p><a href="https://www.tabnine.com/code/java/classes/javax.validation.constraints.Digits">Java validation</a></p>
<h2 id="project-presentation">Project presentation</h2>
<p><a href="https://www.canva.com/design/DAFyf1srgO8/vn_gAuX7iiygCJRc-NXiHw/view?utm_content=DAFyf1srgO8&amp;utm_campaign=designshare&amp;utm_medium=link&amp;utm_source=editor">Project presentation</a></p>
<h2 id="created-by">Created by</h2>
<p>Mona Hassan</p>

