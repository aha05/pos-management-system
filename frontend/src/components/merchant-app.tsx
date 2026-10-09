"use client";

import { useEffect, useRef, useState } from "react";
import {
  ArrowUpRight,
  Bell,
  Plus,
  Search,
  Store,
  Users,
  X,
} from "lucide-react";

import { usePathname }  from "@/components/use-path-name";
import { Sidebar }  from "@/components/sidebar";
import { Dashboard }  from "@/components/dashboard";
import { MerchantsPage }  from "@/components/merchant";
import { GenericPage }  from "@/components/generic-page";
import { Onboarding } from "@/components/onboarding";
import { DetailPage } from "@/components/detail-page";


export function MerchantApp() {
  const path = usePathname() || "/";
  const [open, setOpen] = useState(false);
  const [notificationsOpen, setNotificationsOpen] = useState(false);
  const [notificationsExpanded, setNotificationsExpanded] = useState(false);
  const [notificationsUnread, setNotificationsUnread] = useState(true);
  const [addMerchantOpen, setAddMerchantOpen] = useState(false);
  const notificationRef = useRef<HTMLDivElement>(null);
  const goToOnboarding = () => {
    window.location.href = "/merchants/new";
  };
  useEffect(() => {
    if (!notificationsOpen) return;
    const handlePointerDown = (event: PointerEvent) => {
      if (
        notificationRef.current &&
        !notificationRef.current.contains(event.target as Node)
      )
        setNotificationsOpen(false);
    };
    document.addEventListener("pointerdown", handlePointerDown);
    return () => document.removeEventListener("pointerdown", handlePointerDown);
  }, [notificationsOpen]);
  let content =
    path === "/merchants" ? (
      <MerchantsPage />
    ) : path === "/merchants/new" ? (
      <Onboarding />
    ) : path.includes("/merchants/MER-000001/branches") ? (
      <GenericPage type="branches" />
    ) : path.startsWith("/merchants/MER-000001") ? (
      <DetailPage />
    ) : path === "/merchant-categories" ? (
      <GenericPage type="categories" />
    ) : path === "/fee-profiles" ? (
      <GenericPage type="fees" />
    ) : (
      <Dashboard onAddMerchant={() => setAddMerchantOpen(true)} />
    );
  return (
    <div className="app-shell">
      <Sidebar open={open} setOpen={setOpen} />
      <main className="main">
        <header className="topbar">
          <div className="breadcrumbs">
            <span>POSMS</span>
            <b>/</b>
            <strong>
              {path === "/merchants"
                ? "Merchants"
                : path === "/"
                  ? "Dashboard"
                  : "Merchant operations"}
            </strong>
          </div>
          <div className="top-actions">
            <div className="global-search">
              <Search />
              <input placeholder="Search anything..." />
            </div>
            <div className="notification-wrap" ref={notificationRef}>
              <button
                className="notification"
                aria-label="Notifications"
                aria-expanded={notificationsOpen}
                onClick={() => setNotificationsOpen(!notificationsOpen)}
              >
                <Bell />
                <i />
              </button>
              {notificationsOpen && (
                <div
                  className="notification-menu"
                  onClick={(event) => {
                    const target = event.target as HTMLElement;
                    const label = target.closest("button")?.textContent?.trim();
                    if (label === "Mark all read") {
                      setNotificationsUnread(false);
                    }
                    if (label === "View all") {
                      setNotificationsExpanded(true);
                    }
                    if (label === "View less") {
                      setNotificationsExpanded(false);
                    }
                  }}
                >
                  <div className="menu-heading">
                    <div>
                      <b>Notifications</b>
                      <span>
                        {notificationsUnread
                          ? "3 unread updates"
                          : "All caught up"}
                      </span>
                    </div>
                    <button onClick={() => setNotificationsUnread(false)}>
                      Mark all read
                    </button>
                  </div>
                  <div className="notification-item">
                    <span className="notification-dot blue" />
                    <div>
                      <b>New merchant submitted</b>
                      <p>Swift Ride Ethiopia is ready for review.</p>
                      <small>12 minutes ago</small>
                    </div>
                  </div>
                  <div className="notification-item">
                    <span className="notification-dot amber" />
                    <div>
                      <b>Settlement account needs attention</b>
                      <p>Review the account details for ABC Trading PLC.</p>
                      <small>1 hour ago</small>
                    </div>
                  </div>
                  <div className="notification-item">
                    <span className="notification-dot green" />
                    <div>
                      <b>Onboarding completed</b>
                      <p>Addis Fresh Market is now active.</p>
                      <small>Yesterday</small>
                    </div>
                    {notificationsExpanded && (
                      <div className="notification-item">
                        <span className="notification-dot blue" />
                        <div>
                          <b>Fee profile updated</b>
                          <p>Premium fee profile changes are now active.</p>
                          <small>2 days ago</small>
                        </div>
                      </div>
                    )}
                  </div>
                  <button className="view-all">
                    {notificationsExpanded ? "View less" : "View all"}
                  </button>
                </div>
              )}
            </div>
            <div className="top-avatar">NA</div>
          </div>
        </header>
        <div className="content">{content}</div>
      </main>
      {addMerchantOpen && (
        <div
          className="modal-backdrop"
          role="presentation"
          onMouseDown={(e) => {
            if (e.target === e.currentTarget) setAddMerchantOpen(false);
          }}
        >
          <section
            className="merchant-modal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="add-merchant-title"
          >
            <button
              className="modal-close"
              aria-label="Close"
              onClick={() => setAddMerchantOpen(false)}
            >
              <X />
            </button>
            <div className="modal-icon">
              <Store />
            </div>
            <h2 id="add-merchant-title">Add a new merchant</h2>
            <p>
              Start onboarding a business and configure its merchant services.
            </p>
            <div className="modal-options">
              <button onClick={goToOnboarding}>
                <span>
                  <Plus />
                </span>
                <div>
                  <b>Create merchant profile</b>
                  <small>
                    Enter business, contact, settlement, and fee details.
                  </small>
                </div>
                <ArrowUpRight />
              </button>
              <button onClick={() => setAddMerchantOpen(false)}>
                <span>
                  <Users />
                </span>
                <div>
                  <b>Import merchants</b>
                  <small>Upload a prepared list of merchant profiles.</small>
                </div>
                <ArrowUpRight />
              </button>
            </div>
            <button
              className="button ghost modal-cancel"
              onClick={() => setAddMerchantOpen(false)}
            >
              Cancel
            </button>
          </section>
        </div>
      )}
    </div>
  );
}
