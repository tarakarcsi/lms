<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
  <header>
    <h1>Register</h1>
  </header>
  <div class="center-box">
  <form action="register" method="post">
      <p>Enter your name:</p>
      <input name = "name" type="text" placeholder="Name" required/>
      <p>Enter your e-mail address:</p>
      <input name = "email" type="email" placeholder="E-mail" required/>
      <p>Enter your password:</p>
      <input name = "password1" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="*****"/>
      <p>Confirm password:</p>
      <input name = "password2" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required placeholder="*****"/>
      <div id="message">
          <h3>Password must contain the following:</h3>
          <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
          <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
          <p id="number" class="invalid">A <b>number</b></p>
          <p id="length" class="invalid">Minimum <b>8 characters</b></p>
      </div>
      <p>Select your status:</p>
      <select name = "type">
        <option value="false">Student</option>
        <option value="true">Mentor</option>
      </select><br/>
      <button type="submit">Register</button>
  </form>
  </div>
</body>
</html>
