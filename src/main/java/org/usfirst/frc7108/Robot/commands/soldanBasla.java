package org.usfirst.frc7108.Robot.commands;

import org.usfirst.frc7108.Robot.Robot;
//import org.usfirst.frc7108.Robot.subsystems.Sase;
//import org.usfirst.frc7108.Robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class soldanBasla extends CommandGroup{
	public soldanBasla(){
		requires(Robot.sase);
		this.addSequential(new AutonomusDrive(50));//mesafe(cm)
	/*	this.addSequential(new AutonomousDelay(.5));//sure
		this.addSequential(new AutonomousTurn(.3));// + verince sola,- verince saga doner
		this.addSequential(new AutonomousDelay(.5));
		this.addSequential(new AutonomousTurn(.3));//hiz + aci
		this.addSequential(new AutonomousDelay(.5));
		this.addSequential(new AutonomusDrive(1));
		this.addSequential(new AutonomousDelay(.5));
		this.addSequential(new AutonomousTurn(.3));
		this.addSequential(new AutonomousDelay(.5));
		this.addSequential(new AutonomousTurn(.3));
		*/
		
	}
}

