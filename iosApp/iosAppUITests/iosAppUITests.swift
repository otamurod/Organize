//
//  iosAppUITests.swift
//  iosAppUITests
//
//  Created by Otamurod Safarov on 24/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import XCTest

final class iosAppUITests: XCTestCase {
    private let app = XCUIApplication()

    override func setUp() {
        continueAfterFailure = false
        app.launch()
    }

    func testAboutButtonExistence() {
        XCTAssert(app.buttons["aboutButton"].exists)
    }

    func testOpeningAndClosingAboutPage() {
        app.buttons["aboutButton"].tap()
        let aboutPageTitle = app.staticTexts["About Device"]
        XCTAssert(aboutPageTitle.exists)

        app.navigationBars["About Device"].buttons["Done"].tap()
        let remindersPageTitle = app.staticTexts["Reminders"]
        XCTAssert(remindersPageTitle.exists)
    }
}
