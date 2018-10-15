#!/bin/bash
function FlacToWav(){
	for dir in $1/*
	do
		if [ -d ${dir} ]
		then
			FlacToWav ${dir}
		fi
	done	
	for flacFile in $1/*.flac
	do
		if [ -r ${flacFile} ]
		then
			fileName=` basename -s .flac ${flacFile}`
			`sox ${flacFile} -r 16000 -c 1  $1/${fileName}.wav`
		fi
	done
}
FlacToWav /home/xumingke/LibriSpeech/dev-clean/
