import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


const AddStudent = () => {
  const [student, setStudent] = useState({
    firstName: '',
    lastName: '',
    email: '',
    department: 'Computer Science',
    yearsOfEnrollment: 1,
  });

  const navigate = useNavigate();
  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setStudent({ ...student, [name]: value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/student/addStudent', student);
      alert('Student added successfully');
    } catch (err) {
      console.error(err);
      alert('Error adding student');
    }
  };

  return (
    <div>
        <></>
      <h2>Add Student</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="firstName"
          value={student.firstName}
          onChange={handleChange}
          placeholder="First Name"
          required
        />
        <input
          type="text"
          name="lastName"
          value={student.lastName}
          onChange={handleChange}
          placeholder="Last Name"
          required
        />
        <input
          type="email"
          name="email"
          value={student.email}
          onChange={handleChange}
          placeholder="Email"
          required
        />
        <select
          name="department"
          value={student.department}
          onChange={handleChange}
        >
          <option value="Computer Science">Computer Science</option>
          <option value="Statistics">Statistics</option>
          <option value="Mathametics">Mathamatics</option>
          <option value="Physics">Physics</option>
          <option value="Chemistry">Chemistry</option>  
          <option value="Biology">Biology</option>
          <option value="Geology">Geology</option>
        </select>
        <input
          type="number"
          name="yearsOfEnrollment"
          value={student.yearsOfEnrollment}
          onChange={handleChange}
          placeholder="Years of Enrollment"
          required
        />
        <button type="submit">Add Student</button>
      </form>
      <button onClick={() => navigate('/')}>Back to Student List</button>
      </div>
    
  );
};

export default AddStudent;
