package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.JobField;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest{
    Job jobA;
    Job jobB;
    @Before
    public void createJobs(){
        jobA = new Job("Product tester",new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobB = new Job("Product tester",new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals(jobA.getName(),"Product tester");
        assertEquals(jobA.getEmployer().getValue(),"ACME");
        assertEquals(jobA.getLocation().getValue(),"Desert");
        assertEquals(jobA.getPositionType().getValue(),"Quality control");
        assertEquals(jobA.getCoreCompetency().getValue(),"Persistence");
        assertTrue(jobA.getName() instanceof String);
        assertTrue(jobA.getEmployer() instanceof Employer);
        assertTrue(jobA.getLocation() instanceof Location);
        assertTrue(jobA.getPositionType() instanceof PositionType);
        assertTrue(jobA.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(jobA.equals(jobB));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String output = jobA.toString();
        int lastChar = (output.length() -1);
        assertTrue(output.charAt(0)=='\n');
        assertTrue(output.charAt(lastChar)=='\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String output = jobA.toString();
        assertTrue(output.contains("ID: "));
        assertTrue(output.contains("Name: "));
        assertTrue(output.contains("Product tester"));
        assertTrue(output.contains("Employer: "));
        assertTrue(output.contains("Location: "));
        assertTrue(output.contains("Position Type: "));
        assertTrue(output.contains("Core Competency: "));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        jobA = new Job("",new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String output = jobA.toString();
        assertEquals(jobA.getEmployer().getValue(),"Data not available");
    }
}
